package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements View.OnClickListener {
    final /* synthetic */ bk aXJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(bk bkVar) {
        this.aXJ = bkVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aXJ.aXc.onItemViewClick(view, 13, this.aXJ.mPosition, 0L);
    }
}
