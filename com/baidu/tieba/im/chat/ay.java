package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements View.OnLongClickListener {
    final /* synthetic */ as cFx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(as asVar) {
        this.cFx = asVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.cFx.cEQ.b(view, 11, this.cFx.akG, 0L);
        return true;
    }
}
