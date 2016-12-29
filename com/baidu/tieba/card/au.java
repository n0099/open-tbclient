package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements View.OnClickListener {
    final /* synthetic */ aq bcS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(aq aqVar) {
        this.bcS = aqVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.m mVar;
        cb<com.baidu.tieba.card.data.m> onSubCardOnClickListenner = this.bcS.getOnSubCardOnClickListenner();
        if (onSubCardOnClickListenner != null) {
            view.setTag("2");
            mVar = this.bcS.bcN;
            onSubCardOnClickListenner.a(view, mVar);
        }
    }
}
