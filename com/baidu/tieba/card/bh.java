package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class bh implements View.OnClickListener {
    final /* synthetic */ bc btI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(bc bcVar) {
        this.btI = bcVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.n nVar;
        cf<com.baidu.tieba.card.data.n> onSubCardOnClickListenner = this.btI.getOnSubCardOnClickListenner();
        if (onSubCardOnClickListenner != null) {
            view.setTag("2");
            nVar = this.btI.btx;
            onSubCardOnClickListenner.a(view, nVar);
        }
    }
}
