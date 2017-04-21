package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements View.OnClickListener {
    final /* synthetic */ au bvM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(au auVar) {
        this.bvM = auVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.n nVar;
        if (this.bvM.getOnSubCardOnClickListenner() != null) {
            cf<com.baidu.tieba.card.data.n> onSubCardOnClickListenner = this.bvM.getOnSubCardOnClickListenner();
            nVar = this.bvM.bvH;
            onSubCardOnClickListenner.a(view, nVar);
        }
        this.bvM.TR();
    }
}
