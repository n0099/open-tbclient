package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements View.OnLongClickListener {
    final /* synthetic */ bs a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(bs bsVar) {
        this.a = bsVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.a.d.b(view, 5, this.a.f, 0L);
        return true;
    }
}
