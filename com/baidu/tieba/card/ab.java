package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ y bBU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(y yVar) {
        this.bBU = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.n nVar;
        com.baidu.tieba.card.data.n nVar2;
        nVar = this.bBU.bBD;
        if (nVar != null && this.bBU.Vs() != null) {
            ci<com.baidu.tieba.card.data.n> Vs = this.bBU.Vs();
            nVar2 = this.bBU.bBD;
            Vs.a(view, nVar2);
        }
    }
}
