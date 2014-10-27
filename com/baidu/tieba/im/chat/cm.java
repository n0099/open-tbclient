package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cm implements View.OnLongClickListener {
    final /* synthetic */ cc aPk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(cc ccVar) {
        this.aPk = ccVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.aPk.aOL.b(view, 7, this.aPk.Uy, 0L);
        return true;
    }
}
