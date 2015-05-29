package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu implements View.OnLongClickListener {
    final /* synthetic */ bk baG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(bk bkVar) {
        this.baG = bkVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.baG.aZZ.onItemViewLongClick(view, 7, this.baG.mPosition, 0L);
        return true;
    }
}
