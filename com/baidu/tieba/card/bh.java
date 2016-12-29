package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements View.OnClickListener {
    final /* synthetic */ bg bdd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(bg bgVar) {
        this.bdd = bgVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.n nVar;
        if (this.bdd.getOnSubCardOnClickListenner() != null) {
            cb<com.baidu.tieba.card.data.n> onSubCardOnClickListenner = this.bdd.getOnSubCardOnClickListenner();
            nVar = this.bdd.bcZ;
            onSubCardOnClickListenner.a(view, nVar);
        }
    }
}
