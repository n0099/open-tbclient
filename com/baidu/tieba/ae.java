package com.baidu.tieba;

import android.app.AlertDialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements DialogInterface.OnClickListener {
    final /* synthetic */ MainTabActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(MainTabActivity mainTabActivity) {
        this.a = mainTabActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog;
        if (i != -2) {
            alertDialog = this.a.w;
            alertDialog.dismiss();
            TiebaApplication.d().a(false, true);
            return;
        }
        this.a.a(true);
        TiebaApplication.d().a(true, true);
    }
}
