package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements View.OnClickListener {
    final /* synthetic */ ar cOb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(ar arVar) {
        this.cOb = arVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cOb.cNs.a(view, 4, this.cOb.atx, 0L);
    }
}
