package com.baidu.tieba.home;

import android.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class al implements AdapterView.OnItemClickListener {
    final /* synthetic */ ak a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.a = akVar;
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
