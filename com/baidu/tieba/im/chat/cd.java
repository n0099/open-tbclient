package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cd implements View.OnLongClickListener {
    final /* synthetic */ cc aPk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(cc ccVar) {
        this.aPk = ccVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.aPk.aOL.b(view, 5, this.aPk.Uy, 0L);
        return true;
    }
}
