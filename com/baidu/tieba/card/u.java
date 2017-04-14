package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ t bsE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.bsE = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.m mVar;
        if (this.bsE.getOnSubCardOnClickListenner() != null) {
            cf<com.baidu.tieba.card.data.m> onSubCardOnClickListenner = this.bsE.getOnSubCardOnClickListenner();
            mVar = this.bsE.bsw;
            onSubCardOnClickListenner.a(view, mVar);
        }
    }
}
