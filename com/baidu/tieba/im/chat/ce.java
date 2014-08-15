package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ce implements View.OnClickListener {
    final /* synthetic */ cb a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(cb cbVar) {
        this.a = cbVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.b.a(view, 12, this.a.d, 0L);
    }
}
