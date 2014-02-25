package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class df implements DialogInterface.OnClickListener {
    final /* synthetic */ cz a;
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(cz czVar, int i) {
        this.a = czVar;
        this.b = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.a.b(this.b);
    }
}
