package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    final /* synthetic */ u bvn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(u uVar) {
        this.bvn = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.n nVar;
        com.baidu.tieba.card.data.n nVar2;
        nVar = this.bvn.bvd;
        if (nVar != null && this.bvn.getOnSubCardOnClickListenner() != null) {
            cd<com.baidu.tieba.card.data.n> onSubCardOnClickListenner = this.bvn.getOnSubCardOnClickListenner();
            nVar2 = this.bvn.bvd;
            onSubCardOnClickListenner.a(view, nVar2);
        }
    }
}
