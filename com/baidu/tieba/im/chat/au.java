package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements View.OnClickListener {
    final /* synthetic */ as cFx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(as asVar) {
        this.cFx = asVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cFx.cEP.a(view, 15, this.cFx.akG, 0L);
    }
}
