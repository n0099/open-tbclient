package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements View.OnLongClickListener {
    final /* synthetic */ ar cOb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(ar arVar) {
        this.cOb = arVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.cOb.cNt.b(view, 10, this.cOb.atx, 0L);
        return true;
    }
}
