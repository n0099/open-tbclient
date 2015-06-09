package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements View.OnClickListener {
    final /* synthetic */ bk baH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(bk bkVar) {
        this.baH = bkVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.baH.aZZ.onItemViewClick(view, 7, this.baH.mPosition, 0L);
    }
}
