package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class ax implements View.OnClickListener {
    final /* synthetic */ aw bdG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(aw awVar) {
        this.bdG = awVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.m mVar;
        if (this.bdG.getOnSubCardOnClickListenner() != null) {
            bz<com.baidu.tieba.card.data.m> onSubCardOnClickListenner = this.bdG.getOnSubCardOnClickListenner();
            mVar = this.bdG.bdv;
            onSubCardOnClickListenner.a(view, mVar);
        }
        this.bdG.Ph();
    }
}
