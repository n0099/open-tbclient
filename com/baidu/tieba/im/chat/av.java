package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements View.OnLongClickListener {
    final /* synthetic */ as bsl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(as asVar) {
        this.bsl = asVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.bsl.brE.onItemViewLongClick(view, 15, this.bsl.anL, 0L);
        return true;
    }
}
