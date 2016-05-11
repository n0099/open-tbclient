package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {
    final /* synthetic */ z aQe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(z zVar) {
        this.aQe = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.n nVar;
        com.baidu.tieba.card.a.n nVar2;
        nVar = this.aQe.aPR;
        if (nVar != null && this.aQe.JM() != null) {
            by<com.baidu.tieba.card.a.n> JM = this.aQe.JM();
            nVar2 = this.aQe.aPR;
            JM.a(view, nVar2);
        }
    }
}
