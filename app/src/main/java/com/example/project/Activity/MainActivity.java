package com.example.project.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.project.Adaptor.PopluarAdaptor;
import com.example.project.Domain.CategoryDomain;
import com.example.project.Adaptor.CatregoryAdaptor;
import com.example.project.Domain.FoodDomain;
import com.example.project.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewCategoryList, RecyclerViewPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        recyclerViewPopular();
        BottomNavigation();
    }

    private void BottomNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.cartBtn);
        LinearLayout homeBtn = findViewById(R.id.home_Btn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CartListActivity.class));
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> category = new ArrayList<>();
        category.add((new CategoryDomain("Généraliste", "doct7")));
        category.add((new CategoryDomain("Chirurgien", "doct8")));
        category.add((new CategoryDomain("Spécialité médicale", "doct9")));
        category.add((new CategoryDomain("Dentisterie", "doct10")));
        category.add((new CategoryDomain("ORL", "doct11")));

        adapter = new CatregoryAdaptor(category);
        recyclerViewCategoryList.setAdapter(adapter);
    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerViewPopularList = findViewById(R.id.recyclerView2);
        RecyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodList = new ArrayList<>();
        foodList.add(new FoodDomain("Docteur Adrien", "doct4", "Paris 7è, 1 rue Acacia", 9.76));
        foodList.add(new FoodDomain("Docteur Valérie", "doct5", "Paris 19è, 5 rue Charles de Gaulle", 8.79));
        foodList.add(new FoodDomain("Docteur Amine", "doct6", "Paris 12è, 3 rue Saint Germain", 8.5));

        adapter2 = new PopluarAdaptor(foodList);
        RecyclerViewPopularList.setAdapter(adapter2);


    }
}