package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class ba implements View.OnClickListener {
    final /* synthetic */ aw bdG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(aw awVar) {
        this.bdG = awVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.m mVar;
        bz<com.baidu.tieba.card.data.m> onSubCardOnClickListenner = this.bdG.getOnSubCardOnClickListenner();
        if (onSubCardOnClickListenner != null) {
            view.setTag("1");
            mVar = this.bdG.bdv;
            onSubCardOnClickListenner.a(view, mVar);
        }
    }
}
