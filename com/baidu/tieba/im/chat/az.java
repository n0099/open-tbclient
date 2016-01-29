package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements View.OnClickListener {
    final /* synthetic */ as bPq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(as asVar) {
        this.bPq = asVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bPq.bOI.a(view, 4, this.bPq.anV, 0L);
    }
}
