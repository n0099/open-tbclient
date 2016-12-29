package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class bf implements View.OnClickListener {
    final /* synthetic */ ay bcY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(ay ayVar) {
        this.bcY = ayVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.m mVar;
        if (this.bcY.getOnSubCardOnClickListenner() != null) {
            cb<com.baidu.tieba.card.data.m> onSubCardOnClickListenner = this.bcY.getOnSubCardOnClickListenner();
            mVar = this.bcY.bcN;
            onSubCardOnClickListenner.a(view, mVar);
        }
    }
}
