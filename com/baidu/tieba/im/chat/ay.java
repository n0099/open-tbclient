package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements View.OnLongClickListener {
    final /* synthetic */ as cGg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(as asVar) {
        this.cGg = asVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.cGg.cFz.b(view, 11, this.cGg.aoG, 0L);
        return true;
    }
}
