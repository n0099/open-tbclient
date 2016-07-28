package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements View.OnLongClickListener {
    final /* synthetic */ as cIm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(as asVar) {
        this.cIm = asVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.cIm.cHF.b(view, 11, this.cIm.alw, 0L);
        return true;
    }
}
