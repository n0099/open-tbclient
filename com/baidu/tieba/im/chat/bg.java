package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements View.OnLongClickListener {
    final /* synthetic */ bc aSq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(bc bcVar) {
        this.aSq = bcVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.aSq.mItemViewLongClickListener.onItemViewLongClick(view, 11, this.aSq.mPosition, 0L);
        return true;
    }
}
