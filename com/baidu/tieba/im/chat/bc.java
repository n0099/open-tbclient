package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements View.OnLongClickListener {
    final /* synthetic */ as bPq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(as asVar) {
        this.bPq = asVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.bPq.bOJ.b(view, 3, this.bPq.anV, 0L);
        return true;
    }
}
