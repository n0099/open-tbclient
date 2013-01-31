package com.baidu.tieba.frs;

import android.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements AdapterView.OnItemClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        AlertDialog alertDialog;
        if (i > 0) {
            alertDialog = this.a.U;
            alertDialog.dismiss();
            com.baidu.tieba.a.t tVar = (com.baidu.tieba.a.t) ((ListView) adapterView).getAdapter().getItem(i);
            if (tVar.b() != -1) {
                this.a.l = 1;
                this.a.k = tVar.b();
                this.a.j = tVar.a();
                this.a.m = 1;
                this.a.f = 3;
                this.a.w();
                return;
            }
            this.a.u();
        }
    }
}
