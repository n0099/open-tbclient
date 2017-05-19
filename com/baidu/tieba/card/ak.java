package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements View.OnClickListener {
    final /* synthetic */ ai bvr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ai aiVar) {
        this.bvr = aiVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.n nVar;
        if (this.bvr.getOnSubCardOnClickListenner() != null) {
            cd<com.baidu.tieba.card.data.n> onSubCardOnClickListenner = this.bvr.getOnSubCardOnClickListenner();
            nVar = this.bvr.bvo;
            onSubCardOnClickListenner.a(view, nVar);
        }
    }
}
