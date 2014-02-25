package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bx implements View.OnClickListener {
    final /* synthetic */ bs a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(bs bsVar) {
        this.a = bsVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.c.a(view, 7, this.a.f, 0L);
    }
}
