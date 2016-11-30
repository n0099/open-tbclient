package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements View.OnClickListener {
    final /* synthetic */ as daW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(as asVar) {
        this.daW = asVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.daW.dam.a(view, 10, this.daW.ape, 0L);
    }
}
