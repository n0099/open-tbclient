package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bs implements View.OnLongClickListener {
    final /* synthetic */ br a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(br brVar) {
        this.a = brVar;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        this.a.d.a(5, this.a.f);
        return true;
    }
}
