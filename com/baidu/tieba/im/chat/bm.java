package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements View.OnLongClickListener {
    final /* synthetic */ bc aSq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bc bcVar) {
        this.aSq = bcVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.aSq.mItemViewLongClickListener.onItemViewLongClick(view, 7, this.aSq.mPosition, 0L);
        return true;
    }
}
