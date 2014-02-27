package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class dd implements DialogInterface.OnClickListener {
    final /* synthetic */ cy a;
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dd(cy cyVar, int i) {
        this.a = cyVar;
        this.b = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        r0.e.a(this.b, this.a.j);
    }
}
