package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cf implements View.OnLongClickListener {
    final /* synthetic */ cc a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(cc ccVar) {
        this.a = ccVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.a.c.b(view, 4, this.a.e, 0L);
        return true;
    }
}
