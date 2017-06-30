package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements View.OnClickListener {
    final /* synthetic */ y bBU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(y yVar) {
        this.bBU = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.n nVar;
        if (this.bBU.Vs() != null) {
            ci<com.baidu.tieba.card.data.n> Vs = this.bBU.Vs();
            nVar = this.bBU.bBD;
            Vs.a(view, nVar);
        }
    }
}
