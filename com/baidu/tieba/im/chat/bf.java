package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bf implements DialogInterface.OnClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ bc b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(bc bcVar, int i) {
        this.b = bcVar;
        this.a = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.b.a(this.a);
    }
}
