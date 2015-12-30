package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements View.OnLongClickListener {
    final /* synthetic */ as bLC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(as asVar) {
        this.bLC = asVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.bLC.bKV.onItemViewLongClick(view, 15, this.bLC.anc, 0L);
        return true;
    }
}
