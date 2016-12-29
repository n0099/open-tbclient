package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements View.OnClickListener {
    final /* synthetic */ as cGg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(as asVar) {
        this.cGg = asVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cGg.cFy.a(view, 12, this.cGg.aoG, 0L);
    }
}
