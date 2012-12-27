package com.baidu.tieba.home;

import android.app.AlertDialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements DialogInterface.OnClickListener {
    final /* synthetic */ HomeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(HomeActivity homeActivity) {
        this.a = homeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog;
        t tVar;
        com.baidu.tieba.a.ac acVar;
        t tVar2;
        if (i != -1) {
            alertDialog = this.a.j;
            alertDialog.dismiss();
            return;
        }
        tVar = this.a.i;
        if (tVar == null) {
            HomeActivity homeActivity = this.a;
            HomeActivity homeActivity2 = this.a;
            acVar = this.a.l;
            homeActivity.i = new t(homeActivity2, acVar);
            tVar2 = this.a.i;
            tVar2.execute(new com.baidu.tieba.a.ac[0]);
        }
    }
}
