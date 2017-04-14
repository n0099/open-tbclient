package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements View.OnClickListener {
    final /* synthetic */ ar cOb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(ar arVar) {
        this.cOb = arVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cOb.cNs.a(view, 10, this.cOb.atx, 0L);
    }
}
