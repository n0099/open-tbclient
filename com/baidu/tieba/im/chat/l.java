package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l implements View.OnClickListener {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar) {
        this.a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        r0.a(this.a.G);
        this.a.Q();
        this.a.P();
        this.a.S();
    }
}
