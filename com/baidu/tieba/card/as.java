package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements View.OnClickListener {
    final /* synthetic */ ao bdA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ao aoVar) {
        this.bdA = aoVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.m mVar;
        bz<com.baidu.tieba.card.data.m> onSubCardOnClickListenner = this.bdA.getOnSubCardOnClickListenner();
        if (onSubCardOnClickListenner != null) {
            view.setTag("2");
            mVar = this.bdA.bdv;
            onSubCardOnClickListenner.a(view, mVar);
        }
    }
}
