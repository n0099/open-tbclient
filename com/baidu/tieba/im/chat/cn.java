package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cn implements View.OnLongClickListener {
    final /* synthetic */ ch a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(ch chVar) {
        this.a = chVar;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        this.a.d.b(view, 7, this.a.f, 0L);
        return true;
    }
}
