package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements View.OnClickListener {
    final /* synthetic */ as bZI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(as asVar) {
        this.bZI = asVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bZI.bZa.a(view, 7, this.bZI.aom, 0L);
    }
}
