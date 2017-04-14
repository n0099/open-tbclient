package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements View.OnLongClickListener {
    final /* synthetic */ ar cOb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(ar arVar) {
        this.cOb = arVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.cOb.cNt.b(view, 11, this.cOb.atx, 0L);
        return true;
    }
}
