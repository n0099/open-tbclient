package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements View.OnLongClickListener {
    final /* synthetic */ as daW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(as asVar) {
        this.daW = asVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.daW.dan.b(view, 4, this.daW.ape, 0L);
        return true;
    }
}
