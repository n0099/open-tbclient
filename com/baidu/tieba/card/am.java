package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements View.OnClickListener {
    final /* synthetic */ aj bad;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(aj ajVar) {
        this.bad = ajVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.m mVar;
        if (this.bad.getOnSubCardOnClickListenner() != null) {
            cd<com.baidu.tieba.card.data.m> onSubCardOnClickListenner = this.bad.getOnSubCardOnClickListenner();
            mVar = this.bad.bac;
            onSubCardOnClickListenner.a(view, mVar);
        }
    }
}
