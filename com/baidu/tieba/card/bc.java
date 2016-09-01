package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class bc implements View.OnClickListener {
    final /* synthetic */ ay baf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(ay ayVar) {
        this.baf = ayVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.m mVar;
        cf<com.baidu.tieba.card.data.m> onSubCardOnClickListenner = this.baf.getOnSubCardOnClickListenner();
        if (onSubCardOnClickListenner != null) {
            view.setTag("1");
            mVar = this.baf.aZU;
            onSubCardOnClickListenner.a(view, mVar);
        }
    }
}
