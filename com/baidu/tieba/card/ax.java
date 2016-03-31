package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements View.OnClickListener {
    final /* synthetic */ au aTQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(au auVar) {
        this.aTQ = auVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.v vVar;
        if (this.aTQ.Ld() != null) {
            cj<com.baidu.tieba.card.a.v> Ld = this.aTQ.Ld();
            vVar = this.aTQ.aTM;
            Ld.a(view, vVar);
        }
    }
}
