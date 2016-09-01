package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class be implements View.OnClickListener {
    final /* synthetic */ ay baf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(ay ayVar) {
        this.baf = ayVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.m mVar;
        if (this.baf.getOnSubCardOnClickListenner() != null) {
            cf<com.baidu.tieba.card.data.m> onSubCardOnClickListenner = this.baf.getOnSubCardOnClickListenner();
            mVar = this.baf.aZU;
            onSubCardOnClickListenner.a(view, mVar);
        }
    }
}
