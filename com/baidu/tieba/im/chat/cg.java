package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cg implements View.OnLongClickListener {
    final /* synthetic */ cc a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(cc ccVar) {
        this.a = ccVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.a.c.b(view, 3, this.a.e, 0L);
        return true;
    }
}
