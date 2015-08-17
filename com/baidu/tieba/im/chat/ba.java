package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements View.OnLongClickListener {
    final /* synthetic */ as boC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(as asVar) {
        this.boC = asVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.boC.bnW.onItemViewLongClick(view, 3, this.boC.anz, 0L);
        return true;
    }
}
