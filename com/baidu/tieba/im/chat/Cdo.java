package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.tieba.im.chat.do  reason: invalid class name */
/* loaded from: classes.dex */
public final class Cdo implements DialogInterface.OnClickListener {
    final /* synthetic */ dj a;
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cdo(dj djVar, int i) {
        this.a = djVar;
        this.b = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        r0.e.a(this.b, this.a.j);
    }
}
