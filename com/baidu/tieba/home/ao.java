package com.baidu.tieba.home;

import android.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class ao implements AdapterView.OnItemClickListener {
    final /* synthetic */ an a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(an anVar) {
        this.a = anVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        SearchActivity searchActivity;
        SearchActivity searchActivity2;
        SearchActivity searchActivity3;
        AlertDialog alertDialog;
        switch (i) {
            case 0:
                searchActivity2 = this.a.a;
                searchActivity2.c(0);
                break;
            case 1:
                searchActivity = this.a.a;
                searchActivity.c(1);
                break;
        }
        searchActivity3 = this.a.a;
        alertDialog = searchActivity3.y;
        alertDialog.dismiss();
    }
}
