package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class bb implements View.OnClickListener {
    final /* synthetic */ ay bvU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ay ayVar) {
        this.bvU = ayVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.l lVar;
        cd<com.baidu.tieba.card.data.l> onSubCardOnClickListenner = this.bvU.getOnSubCardOnClickListenner();
        if (onSubCardOnClickListenner != null) {
            view.setTag("1");
            lVar = this.bvU.bvE;
            onSubCardOnClickListenner.a(view, lVar);
        }
    }
}
