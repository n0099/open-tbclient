package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class bi implements View.OnClickListener {
    final /* synthetic */ bc bmN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(bc bcVar) {
        this.bmN = bcVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.n nVar;
        if (this.bmN.getOnSubCardOnClickListenner() != null) {
            cf<com.baidu.tieba.card.data.n> onSubCardOnClickListenner = this.bmN.getOnSubCardOnClickListenner();
            nVar = this.bmN.bmC;
            onSubCardOnClickListenner.a(view, nVar);
        }
    }
}
