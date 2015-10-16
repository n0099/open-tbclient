package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements View.OnLongClickListener {
    final /* synthetic */ as bsl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(as asVar) {
        this.bsl = asVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.bsl.brE.onItemViewLongClick(view, 10, this.bsl.anL, 0L);
        return true;
    }
}
