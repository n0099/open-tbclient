package com.baidu.tieba.im.chat;

import android.app.AlertDialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements DialogInterface.OnClickListener {
    final /* synthetic */ bp a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bp bpVar) {
        this.a = bpVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog;
        alertDialog = this.a.d;
        alertDialog.dismiss();
    }
}
