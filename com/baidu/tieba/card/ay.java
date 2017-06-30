package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements View.OnClickListener {
    final /* synthetic */ au bCn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(au auVar) {
        this.bCn = auVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.l lVar;
        if (this.bCn.Vs() != null) {
            ci<com.baidu.tieba.card.data.l> Vs = this.bCn.Vs();
            lVar = this.bCn.bAA;
            Vs.a(view, lVar);
        }
    }
}
