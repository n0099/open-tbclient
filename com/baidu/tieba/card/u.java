package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ t buX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.buX = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.m mVar;
        if (this.buX.getOnSubCardOnClickListenner() != null) {
            cf<com.baidu.tieba.card.data.m> onSubCardOnClickListenner = this.buX.getOnSubCardOnClickListenner();
            mVar = this.buX.buP;
            onSubCardOnClickListenner.a(view, mVar);
        }
    }
}
