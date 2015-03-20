package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements View.OnClickListener {
    final /* synthetic */ bk aXJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(bk bkVar) {
        this.aXJ = bkVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aXJ.aXc.onItemViewClick(view, 10, this.aXJ.mPosition, 0L);
    }
}
