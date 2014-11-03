package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cj implements View.OnClickListener {
    final /* synthetic */ cc aPy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(cc ccVar) {
        this.aPy = ccVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aPy.aOY.a(view, 13, this.aPy.UC, 0L);
    }
}
