package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements View.OnClickListener {
    final /* synthetic */ aj bdl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(aj ajVar) {
        this.bdl = ajVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.m mVar;
        if (this.bdl.getOnSubCardOnClickListenner() != null) {
            bz<com.baidu.tieba.card.data.m> onSubCardOnClickListenner = this.bdl.getOnSubCardOnClickListenner();
            mVar = this.bdl.bdk;
            onSubCardOnClickListenner.a(view, mVar);
        }
    }
}
