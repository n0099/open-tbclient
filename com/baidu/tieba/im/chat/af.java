package com.baidu.tieba.im.chat;

import android.app.AlertDialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements DialogInterface.OnClickListener {
    final /* synthetic */ ad a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ad adVar) {
        this.a = adVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog;
        alertDialog = this.a.o;
        alertDialog.dismiss();
    }
}
