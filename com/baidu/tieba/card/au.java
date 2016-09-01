package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements View.OnClickListener {
    final /* synthetic */ aq aZZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(aq aqVar) {
        this.aZZ = aqVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.m mVar;
        cf<com.baidu.tieba.card.data.m> onSubCardOnClickListenner = this.aZZ.getOnSubCardOnClickListenner();
        if (onSubCardOnClickListenner != null) {
            view.setTag("2");
            mVar = this.aZZ.aZU;
            onSubCardOnClickListenner.a(view, mVar);
        }
    }
}
