package com.baidu.tieba.im.chat;

import android.app.AlertDialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements DialogInterface.OnClickListener {
    final /* synthetic */ av a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(av avVar) {
        this.a = avVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog;
        alertDialog = this.a.e;
        alertDialog.dismiss();
    }
}
