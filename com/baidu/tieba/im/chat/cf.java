package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cf implements View.OnClickListener {
    final /* synthetic */ cc aPk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(cc ccVar) {
        this.aPk = ccVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aPk.aOK.a(view, 12, this.aPk.Uy, 0L);
    }
}
