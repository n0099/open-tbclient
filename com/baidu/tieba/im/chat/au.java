package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements View.OnClickListener {
    final /* synthetic */ as cVl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(as asVar) {
        this.cVl = asVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cVl.cUE.a(view, 15, this.cVl.aok, 0L);
    }
}
