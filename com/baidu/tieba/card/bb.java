package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class bb implements View.OnClickListener {
    final /* synthetic */ aw bax;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(aw awVar) {
        this.bax = awVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.m mVar;
        cd<com.baidu.tieba.card.data.m> onSubCardOnClickListenner = this.bax.getOnSubCardOnClickListenner();
        if (onSubCardOnClickListenner != null) {
            view.setTag("2");
            mVar = this.bax.bal;
            onSubCardOnClickListenner.a(view, mVar);
        }
    }
}
