package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements View.OnClickListener {
    final /* synthetic */ bf bvZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(bf bfVar) {
        this.bvZ = bfVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.m mVar;
        if (this.bvZ.getOnSubCardOnClickListenner() != null) {
            cd<com.baidu.tieba.card.data.m> onSubCardOnClickListenner = this.bvZ.getOnSubCardOnClickListenner();
            mVar = this.bvZ.bvV;
            onSubCardOnClickListenner.a(view, mVar);
        }
    }
}
