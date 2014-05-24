package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ch implements View.OnClickListener {
    final /* synthetic */ cc a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(cc ccVar) {
        this.a = ccVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.b.a(view, 7, this.a.e, 0L);
    }
}
