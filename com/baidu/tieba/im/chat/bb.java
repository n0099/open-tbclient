package com.baidu.tieba.im.chat;

import android.app.AlertDialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements DialogInterface.OnClickListener {
    final /* synthetic */ az a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(az azVar) {
        this.a = azVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog;
        alertDialog = this.a.o;
        alertDialog.dismiss();
    }
}
