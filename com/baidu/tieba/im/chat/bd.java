package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements View.OnClickListener {
    final /* synthetic */ ar cPE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(ar arVar) {
        this.cPE = arVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cPE.cOV.a(view, 7, this.cPE.ath, 0L);
    }
}
