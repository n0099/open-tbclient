package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k implements View.OnClickListener {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a aVar) {
        this.a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        r0.a(this.a.G);
        a.h(this.a);
        this.a.R();
    }
}
