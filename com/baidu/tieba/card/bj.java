package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class bj implements View.OnClickListener {
    final /* synthetic */ bc bvS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(bc bcVar) {
        this.bvS = bcVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.n nVar;
        if (this.bvS.getOnSubCardOnClickListenner() != null) {
            cf<com.baidu.tieba.card.data.n> onSubCardOnClickListenner = this.bvS.getOnSubCardOnClickListenner();
            nVar = this.bvS.bvH;
            onSubCardOnClickListenner.a(view, nVar);
        }
    }
}
