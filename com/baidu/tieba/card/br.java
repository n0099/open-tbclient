package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements View.OnClickListener {
    final /* synthetic */ bq aQP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(bq bqVar) {
        this.aQP = bqVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.n nVar;
        if (this.aQP.JO() != null) {
            by<com.baidu.tieba.card.a.n> JO = this.aQP.JO();
            nVar = this.aQP.aPR;
            JO.a(view, nVar);
        }
    }
}
