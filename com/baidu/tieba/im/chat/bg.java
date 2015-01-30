package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements View.OnLongClickListener {
    final /* synthetic */ bc aSr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(bc bcVar) {
        this.aSr = bcVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.aSr.mItemViewLongClickListener.onItemViewLongClick(view, 11, this.aSr.mPosition, 0L);
        return true;
    }
}
