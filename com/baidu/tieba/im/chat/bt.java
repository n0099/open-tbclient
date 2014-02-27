package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bt implements View.OnClickListener {
    final /* synthetic */ br a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(br brVar) {
        this.a = brVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.c.a(view, 4, this.a.f);
    }
}
