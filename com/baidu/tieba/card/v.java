package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ t bsM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.bsM = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.m mVar;
        if (this.bsM.getOnSubCardOnClickListenner() != null) {
            cf<com.baidu.tieba.card.data.m> onSubCardOnClickListenner = this.bsM.getOnSubCardOnClickListenner();
            mVar = this.bsM.bsE;
            onSubCardOnClickListenner.a(view, mVar);
        }
    }
}
