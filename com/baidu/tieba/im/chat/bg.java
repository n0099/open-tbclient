package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements View.OnLongClickListener {
    final /* synthetic */ as bHV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(as asVar) {
        this.bHV = asVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.bHV.bHo.onItemViewLongClick(view, 10, this.bHV.apI, 0L);
        return true;
    }
}
