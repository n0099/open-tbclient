package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl implements View.OnClickListener {
    final /* synthetic */ bc aSq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bc bcVar) {
        this.aSq = bcVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aSq.mItemViewClickListener.onItemViewClick(view, 7, this.aSq.mPosition, 0L);
    }
}
