package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ch implements View.OnClickListener {
    final /* synthetic */ cc aPk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(cc ccVar) {
        this.aPk = ccVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aPk.aOK.a(view, 4, this.aPk.Uy, 0L);
    }
}
