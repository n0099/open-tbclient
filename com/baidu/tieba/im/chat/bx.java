package com.baidu.tieba.im.chat;

import android.app.AlertDialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bx implements DialogInterface.OnClickListener {
    final /* synthetic */ bv a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(bv bvVar) {
        this.a = bvVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog;
        alertDialog = this.a.n;
        alertDialog.dismiss();
    }
}
