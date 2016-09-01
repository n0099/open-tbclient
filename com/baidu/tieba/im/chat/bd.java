package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements View.OnLongClickListener {
    final /* synthetic */ as cTR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(as asVar) {
        this.cTR = asVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.cTR.cTl.b(view, 3, this.cTR.aoC, 0L);
        return true;
    }
}
