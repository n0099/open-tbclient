package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements View.OnClickListener {
    final /* synthetic */ as bHV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(as asVar) {
        this.bHV = asVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bHV.bHn.onItemViewClick(view, 13, this.bHV.apI, 0L);
    }
}
