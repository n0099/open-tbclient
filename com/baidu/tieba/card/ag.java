package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {
    final /* synthetic */ u bvn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(u uVar) {
        this.bvn = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.n nVar;
        if (this.bvn.getOnSubCardOnClickListenner() != null) {
            cd<com.baidu.tieba.card.data.n> onSubCardOnClickListenner = this.bvn.getOnSubCardOnClickListenner();
            nVar = this.bvn.bvd;
            onSubCardOnClickListenner.a(view, nVar);
        }
    }
}
