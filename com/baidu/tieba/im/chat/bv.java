package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements View.OnClickListener {
    final /* synthetic */ bk aXZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(bk bkVar) {
        this.aXZ = bkVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aXZ.aXs.onItemViewClick(view, 10, this.aXZ.mPosition, 0L);
    }
}
