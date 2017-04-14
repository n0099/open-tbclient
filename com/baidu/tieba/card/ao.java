package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {
    final /* synthetic */ al btc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(al alVar) {
        this.btc = alVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.p pVar;
        if (this.btc.getOnSubCardOnClickListenner() != null) {
            cf<com.baidu.tieba.card.data.p> onSubCardOnClickListenner = this.btc.getOnSubCardOnClickListenner();
            pVar = this.btc.bsZ;
            onSubCardOnClickListenner.a(view, pVar);
        }
    }
}
