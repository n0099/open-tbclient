package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {
    final /* synthetic */ al aZM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(al alVar) {
        this.aZM = alVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.m mVar;
        if (this.aZM.getOnSubCardOnClickListenner() != null) {
            cf<com.baidu.tieba.card.data.m> onSubCardOnClickListenner = this.aZM.getOnSubCardOnClickListenner();
            mVar = this.aZM.aZL;
            onSubCardOnClickListenner.a(view, mVar);
        }
    }
}
