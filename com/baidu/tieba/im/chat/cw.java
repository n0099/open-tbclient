package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class cw implements DialogInterface.OnClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ cp b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cw(cp cpVar, int i) {
        this.b = cpVar;
        this.a = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.b.b(this.a);
    }
}
