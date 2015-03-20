package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements View.OnLongClickListener {
    final /* synthetic */ bk aXJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(bk bkVar) {
        this.aXJ = bkVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.aXJ.aXd.onItemViewLongClick(view, 10, this.aXJ.mPosition, 0L);
        return true;
    }
}
