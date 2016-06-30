package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements View.OnLongClickListener {
    final /* synthetic */ as cFx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar) {
        this.cFx = asVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.cFx.cEQ.b(view, 5, this.cFx.akG, 0L);
        return true;
    }
}
