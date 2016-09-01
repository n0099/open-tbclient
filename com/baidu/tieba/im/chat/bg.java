package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements View.OnClickListener {
    final /* synthetic */ as cTR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(as asVar) {
        this.cTR = asVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cTR.cTk.a(view, 10, this.cTR.aoC, 0L);
    }
}
