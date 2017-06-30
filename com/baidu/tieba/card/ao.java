package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {
    final /* synthetic */ am bBY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(am amVar) {
        this.bBY = amVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.n nVar;
        if (this.bBY.Vs() != null) {
            ci<com.baidu.tieba.card.data.n> Vs = this.bBY.Vs();
            nVar = this.bBY.bBV;
            Vs.a(view, nVar);
        }
    }
}
