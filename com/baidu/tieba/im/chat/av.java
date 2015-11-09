package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements View.OnLongClickListener {
    final /* synthetic */ as bsP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(as asVar) {
        this.bsP = asVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.bsP.bsi.onItemViewLongClick(view, 15, this.bsP.anQ, 0L);
        return true;
    }
}
