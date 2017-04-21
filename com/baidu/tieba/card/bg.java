package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class bg implements View.OnClickListener {
    final /* synthetic */ bc bvS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(bc bcVar) {
        this.bvS = bcVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.n nVar;
        cf<com.baidu.tieba.card.data.n> onSubCardOnClickListenner = this.bvS.getOnSubCardOnClickListenner();
        if (onSubCardOnClickListenner != null) {
            view.setTag("1");
            nVar = this.bvS.bvH;
            onSubCardOnClickListenner.a(view, nVar);
        }
    }
}
