package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements View.OnClickListener {
    final /* synthetic */ as bPq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(as asVar) {
        this.bPq = asVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bPq.bOI.a(view, 15, this.bPq.anV, 0L);
    }
}
