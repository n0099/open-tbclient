package com.baidu.tieba.home;

import android.app.AlertDialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements DialogInterface.OnClickListener {
    final /* synthetic */ HomeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(HomeActivity homeActivity) {
        this.a = homeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog;
        z zVar;
        com.baidu.tieba.a.y yVar;
        z zVar2;
        if (i == -1) {
            zVar = this.a.o;
            if (zVar == null) {
                HomeActivity homeActivity = this.a;
                HomeActivity homeActivity2 = this.a;
                yVar = this.a.r;
                homeActivity.o = new z(homeActivity2, yVar);
                zVar2 = this.a.o;
                zVar2.execute(new com.baidu.tieba.a.y[0]);
                return;
            }
            return;
        }
        alertDialog = this.a.p;
        alertDialog.dismiss();
    }
}
