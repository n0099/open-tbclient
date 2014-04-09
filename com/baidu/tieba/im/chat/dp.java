package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class dp implements DialogInterface.OnClickListener {
    final /* synthetic */ dj a;
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dp(dj djVar, int i) {
        this.a = djVar;
        this.b = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.a.e.b(this.b);
    }
}
