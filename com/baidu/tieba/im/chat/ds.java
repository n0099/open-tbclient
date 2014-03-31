package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ds implements DialogInterface.OnClickListener {
    final /* synthetic */ dn a;
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ds(dn dnVar, int i) {
        this.a = dnVar;
        this.b = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        r0.e.a(this.b, this.a.j);
    }
}
