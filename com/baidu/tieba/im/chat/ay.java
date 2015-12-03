package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements View.OnLongClickListener {
    final /* synthetic */ as bHV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(as asVar) {
        this.bHV = asVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.bHV.bHo.onItemViewLongClick(view, 11, this.bHV.apI, 0L);
        return true;
    }
}
