package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements View.OnLongClickListener {
    final /* synthetic */ as bPq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(as asVar) {
        this.bPq = asVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.bPq.bOJ.b(view, 10, this.bPq.anV, 0L);
        return true;
    }
}
