package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements View.OnClickListener {
    final /* synthetic */ as bsP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(as asVar) {
        this.bsP = asVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bsP.bsh.onItemViewClick(view, 12, this.bsP.anQ, 0L);
    }
}
