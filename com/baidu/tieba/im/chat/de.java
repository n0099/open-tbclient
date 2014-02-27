package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class de implements DialogInterface.OnClickListener {
    final /* synthetic */ cy a;
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public de(cy cyVar, int i) {
        this.a = cyVar;
        this.b = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.a.e.b(this.b);
    }
}
