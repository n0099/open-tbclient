package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements View.OnClickListener {
    final /* synthetic */ bc aSr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(bc bcVar) {
        this.aSr = bcVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aSr.mItemViewClickListener.onItemViewClick(view, 11, this.aSr.mPosition, 0L);
    }
}
