package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class bd implements View.OnClickListener {
    final /* synthetic */ ay bvU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(ay ayVar) {
        this.bvU = ayVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.l lVar;
        if (this.bvU.getOnSubCardOnClickListenner() != null) {
            cd<com.baidu.tieba.card.data.l> onSubCardOnClickListenner = this.bvU.getOnSubCardOnClickListenner();
            lVar = this.bvU.bvE;
            onSubCardOnClickListenner.a(view, lVar);
        }
    }
}
