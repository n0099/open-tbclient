package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements View.OnClickListener {
    final /* synthetic */ bq aQP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(bq bqVar) {
        this.aQP = bqVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.n nVar;
        com.baidu.tieba.card.a.n nVar2;
        nVar = this.aQP.aPR;
        if (nVar != null && this.aQP.JO() != null) {
            by<com.baidu.tieba.card.a.n> JO = this.aQP.JO();
            nVar2 = this.aQP.aPR;
            JO.a(view, nVar2);
        }
    }
}
