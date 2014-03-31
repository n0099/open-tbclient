package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cj implements View.OnClickListener {
    final /* synthetic */ ch a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(ch chVar) {
        this.a = chVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.c.a(view, 4, this.a.f, 0L);
    }
}
