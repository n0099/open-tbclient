package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements View.OnLongClickListener {
    final /* synthetic */ as bpa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar) {
        this.bpa = asVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.bpa.bou.onItemViewLongClick(view, 5, this.bpa.apk, 0L);
        return true;
    }
}
