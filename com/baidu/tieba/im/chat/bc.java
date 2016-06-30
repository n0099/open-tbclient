package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements View.OnClickListener {
    final /* synthetic */ as cFx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(as asVar) {
        this.cFx = asVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cFx.cEP.a(view, 13, this.cFx.akG, 0L);
    }
}
