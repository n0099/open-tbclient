package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements View.OnClickListener {
    final /* synthetic */ ao baq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ao aoVar) {
        this.baq = aoVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.m mVar;
        cd<com.baidu.tieba.card.data.m> onSubCardOnClickListenner = this.baq.getOnSubCardOnClickListenner();
        if (onSubCardOnClickListenner != null) {
            view.setTag("2");
            mVar = this.baq.bal;
            onSubCardOnClickListenner.a(view, mVar);
        }
    }
}
