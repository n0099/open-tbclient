package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class bj implements View.OnClickListener {
    final /* synthetic */ bc btI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(bc bcVar) {
        this.btI = bcVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.n nVar;
        if (this.btI.getOnSubCardOnClickListenner() != null) {
            cf<com.baidu.tieba.card.data.n> onSubCardOnClickListenner = this.btI.getOnSubCardOnClickListenner();
            nVar = this.btI.btx;
            onSubCardOnClickListenner.a(view, nVar);
        }
    }
}
