package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements View.OnLongClickListener {
    final /* synthetic */ bc aSq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bc bcVar) {
        this.aSq = bcVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.aSq.mItemViewLongClickListener.onItemViewLongClick(view, 5, this.aSq.mPosition, 0L);
        return true;
    }
}
