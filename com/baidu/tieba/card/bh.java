package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class bh implements View.OnClickListener {
    final /* synthetic */ bc bmN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(bc bcVar) {
        this.bmN = bcVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.n nVar;
        cf<com.baidu.tieba.card.data.n> onSubCardOnClickListenner = this.bmN.getOnSubCardOnClickListenner();
        if (onSubCardOnClickListenner != null) {
            view.setTag("2");
            nVar = this.bmN.bmC;
            onSubCardOnClickListenner.a(view, nVar);
        }
    }
}
