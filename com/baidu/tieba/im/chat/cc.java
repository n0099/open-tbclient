package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc implements View.OnLongClickListener {
    final /* synthetic */ cb a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(cb cbVar) {
        this.a = cbVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.a.c.b(view, 5, this.a.d, 0L);
        return true;
    }
}
