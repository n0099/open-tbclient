package com.baidu.tieba;

import android.app.AlertDialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements DialogInterface.OnClickListener {
    final /* synthetic */ UpdateDialog a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(UpdateDialog updateDialog) {
        this.a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        if (i == -1) {
            alertDialog2 = this.a.d;
            alertDialog2.dismiss();
            this.a.i();
        } else if (i == -2) {
            alertDialog = this.a.d;
            alertDialog.dismiss();
            this.a.j();
        }
    }
}
