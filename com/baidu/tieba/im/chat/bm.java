package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements View.OnClickListener {
    final /* synthetic */ bk baG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bk bkVar) {
        this.baG = bkVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.baG.aZY.onItemViewClick(view, 11, this.baG.mPosition, 0L);
    }
}
