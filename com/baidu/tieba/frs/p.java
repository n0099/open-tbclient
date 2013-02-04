package com.baidu.tieba.frs;

import android.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements AdapterView.OnItemClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        AlertDialog alertDialog;
        if (i <= 0) {
            return;
        }
        alertDialog = this.a.T;
        alertDialog.dismiss();
        com.baidu.tieba.a.s sVar = (com.baidu.tieba.a.s) ((ListView) adapterView).getAdapter().getItem(i);
        if (sVar.b() == -1) {
            this.a.t();
            return;
        }
        this.a.k = 1;
        this.a.j = sVar.b();
        this.a.i = sVar.a();
        this.a.l = 1;
        this.a.e = 3;
        this.a.v();
    }
}
