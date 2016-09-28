package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class ax implements View.OnClickListener {
    final /* synthetic */ aw bax;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(aw awVar) {
        this.bax = awVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.m mVar;
        if (this.bax.getOnSubCardOnClickListenner() != null) {
            cd<com.baidu.tieba.card.data.m> onSubCardOnClickListenner = this.bax.getOnSubCardOnClickListenner();
            mVar = this.bax.bal;
            onSubCardOnClickListenner.a(view, mVar);
        }
        this.bax.Of();
    }
}
