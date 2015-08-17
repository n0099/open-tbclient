package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements View.OnLongClickListener {
    final /* synthetic */ as boC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(as asVar) {
        this.boC = asVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.boC.bnW.onItemViewLongClick(view, 7, this.boC.anz, 0L);
        return true;
    }
}
