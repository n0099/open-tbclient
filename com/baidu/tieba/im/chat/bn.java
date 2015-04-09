package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn implements View.OnClickListener {
    final /* synthetic */ bk aXZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bk bkVar) {
        this.aXZ = bkVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aXZ.aXs.onItemViewClick(view, 12, this.aXZ.mPosition, 0L);
    }
}
