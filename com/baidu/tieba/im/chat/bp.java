package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp implements View.OnClickListener {
    final /* synthetic */ bk aXZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(bk bkVar) {
        this.aXZ = bkVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aXZ.aXs.onItemViewClick(view, 4, this.aXZ.mPosition, 0L);
    }
}
