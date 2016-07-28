package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements View.OnClickListener {
    final /* synthetic */ as cIm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(as asVar) {
        this.cIm = asVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cIm.cHE.a(view, 13, this.cIm.alw, 0L);
    }
}
