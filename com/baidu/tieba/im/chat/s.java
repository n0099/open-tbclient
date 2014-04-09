package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class s implements View.OnClickListener {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(h hVar) {
        this.a = hVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        r0.a(this.a.H);
        this.a.S();
        this.a.R();
        this.a.U();
    }
}
