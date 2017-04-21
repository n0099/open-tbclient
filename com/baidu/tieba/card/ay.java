package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements View.OnClickListener {
    final /* synthetic */ au bvM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(au auVar) {
        this.bvM = auVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.n nVar;
        cf<com.baidu.tieba.card.data.n> onSubCardOnClickListenner = this.bvM.getOnSubCardOnClickListenner();
        if (onSubCardOnClickListenner != null) {
            view.setTag("2");
            nVar = this.bvM.bvH;
            onSubCardOnClickListenner.a(view, nVar);
        }
    }
}
