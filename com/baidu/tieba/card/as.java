package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements View.OnClickListener {
    final /* synthetic */ aq bvK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(aq aqVar) {
        this.bvK = aqVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.l lVar;
        cd<com.baidu.tieba.card.data.l> onSubCardOnClickListenner = this.bvK.getOnSubCardOnClickListenner();
        if (onSubCardOnClickListenner != null) {
            view.setTag("2");
            lVar = this.bvK.bvE;
            onSubCardOnClickListenner.a(view, lVar);
        }
    }
}
