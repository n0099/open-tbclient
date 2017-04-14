package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class bd implements View.OnClickListener {
    final /* synthetic */ bc btA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bc bcVar) {
        this.btA = bcVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.n nVar;
        if (this.btA.getOnSubCardOnClickListenner() != null) {
            cf<com.baidu.tieba.card.data.n> onSubCardOnClickListenner = this.btA.getOnSubCardOnClickListenner();
            nVar = this.btA.btp;
            onSubCardOnClickListenner.a(view, nVar);
        }
        this.btA.SP();
    }
}
