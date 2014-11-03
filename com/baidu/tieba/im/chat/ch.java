package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ch implements View.OnClickListener {
    final /* synthetic */ cc aPy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(cc ccVar) {
        this.aPy = ccVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aPy.aOY.a(view, 4, this.aPy.UC, 0L);
    }
}
