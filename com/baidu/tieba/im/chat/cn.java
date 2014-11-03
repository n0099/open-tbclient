package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cn implements View.OnClickListener {
    final /* synthetic */ cc aPy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(cc ccVar) {
        this.aPy = ccVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aPy.aOY.a(view, 10, this.aPy.UC, 0L);
    }
}
