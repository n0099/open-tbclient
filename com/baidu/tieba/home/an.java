package com.baidu.tieba.home;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements View.OnClickListener {
    final /* synthetic */ SearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(SearchActivity searchActivity) {
        this.a = searchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        bc bcVar;
        int i;
        bc bcVar2;
        AlertDialog alertDialog3;
        View view2;
        Button button;
        AlertDialog alertDialog4;
        AlertDialog alertDialog5;
        ListView listView;
        ImageView imageView;
        ListView listView2;
        ImageView imageView2;
        ListView listView3;
        AlertDialog alertDialog6;
        View view3;
        View view4;
        View view5;
        ListView listView4;
        bc bcVar3;
        ListView listView5;
        alertDialog = this.a.y;
        if (alertDialog == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
            this.a.y = builder.create();
            alertDialog6 = this.a.y;
            alertDialog6.setCanceledOnTouchOutside(true);
            LayoutInflater layoutInflater = this.a.getLayoutInflater();
            this.a.z = layoutInflater.inflate(R.layout.search_select_dialog, (ViewGroup) null);
            SearchActivity searchActivity = this.a;
            view3 = this.a.z;
            searchActivity.B = (ImageView) view3.findViewById(R.id.head);
            SearchActivity searchActivity2 = this.a;
            view4 = this.a.z;
            searchActivity2.C = (ListView) view4.findViewById(R.id.list);
            SearchActivity searchActivity3 = this.a;
            view5 = this.a.z;
            searchActivity3.C = (ListView) view5.findViewById(R.id.list);
            this.a.A = new bc(this.a);
            listView4 = this.a.C;
            bcVar3 = this.a.A;
            listView4.setAdapter((ListAdapter) bcVar3);
            listView5 = this.a.C;
            listView5.setOnItemClickListener(new ao(this));
        }
        alertDialog2 = this.a.y;
        alertDialog2.show();
        bcVar = this.a.A;
        i = this.a.D;
        bcVar.a(i);
        bcVar2 = this.a.A;
        bcVar2.notifyDataSetChanged();
        alertDialog3 = this.a.y;
        view2 = this.a.z;
        alertDialog3.setContentView(view2);
        button = this.a.f;
        int height = button.getHeight();
        alertDialog4 = this.a.y;
        WindowManager.LayoutParams attributes = alertDialog4.getWindow().getAttributes();
        attributes.gravity = 51;
        attributes.x = 2;
        attributes.y = height;
        attributes.alpha = 1.0f;
        attributes.width = com.baidu.tieba.c.ai.a(this.a, 80.0f);
        attributes.height = -2;
        alertDialog5 = this.a.y;
        alertDialog5.getWindow().setAttributes(attributes);
        int ag = TiebaApplication.b().ag();
        listView = this.a.C;
        com.baidu.tieba.c.ae.b(listView, ag);
        if (ag == 1) {
            imageView2 = this.a.B;
            com.baidu.tieba.c.ae.i(imageView2, R.drawable.search_select_triangle_1);
            listView3 = this.a.C;
            com.baidu.tieba.c.ae.i(listView3, R.drawable.search_select_list_1);
            return;
        }
        imageView = this.a.B;
        com.baidu.tieba.c.ae.i(imageView, R.drawable.search_select_triangle);
        listView2 = this.a.C;
        com.baidu.tieba.c.ae.i(listView2, R.drawable.search_select_list);
    }
}
