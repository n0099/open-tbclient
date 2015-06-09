package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo implements View.OnLongClickListener {
    final /* synthetic */ bk baH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(bk bkVar) {
        this.baH = bkVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.baH.baa.onItemViewLongClick(view, 11, this.baH.mPosition, 0L);
        return true;
    }
}
