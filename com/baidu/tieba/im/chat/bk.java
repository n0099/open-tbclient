package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements View.OnLongClickListener {
    final /* synthetic */ bc aSr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(bc bcVar) {
        this.aSr = bcVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.aSr.mItemViewLongClickListener.onItemViewLongClick(view, 3, this.aSr.mPosition, 0L);
        return true;
    }
}
