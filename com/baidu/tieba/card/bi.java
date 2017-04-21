package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class bi implements View.OnClickListener {
    final /* synthetic */ bc bvS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(bc bcVar) {
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
