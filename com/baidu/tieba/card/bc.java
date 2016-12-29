package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class bc implements View.OnClickListener {
    final /* synthetic */ ay bcY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(ay ayVar) {
        this.bcY = ayVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.m mVar;
        cb<com.baidu.tieba.card.data.m> onSubCardOnClickListenner = this.bcY.getOnSubCardOnClickListenner();
        if (onSubCardOnClickListenner != null) {
            view.setTag("1");
            mVar = this.bcY.bcN;
            onSubCardOnClickListenner.a(view, mVar);
        }
    }
}
