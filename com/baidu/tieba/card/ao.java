package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {
    final /* synthetic */ al bcD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(al alVar) {
        this.bcD = alVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.m mVar;
        if (this.bcD.getOnSubCardOnClickListenner() != null) {
            cb<com.baidu.tieba.card.data.m> onSubCardOnClickListenner = this.bcD.getOnSubCardOnClickListenner();
            mVar = this.bcD.bcC;
            onSubCardOnClickListenner.a(view, mVar);
        }
    }
}
