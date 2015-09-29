package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements View.OnClickListener {
    final /* synthetic */ as bsa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(as asVar) {
        this.bsa = asVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bsa.brs.onItemViewClick(view, 15, this.bsa.anK, 0L);
    }
}
