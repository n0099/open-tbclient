package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ p buU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.buU = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.k kVar;
        if (this.buU.getOnSubCardOnClickListenner() != null) {
            cd<com.baidu.tieba.card.data.k> onSubCardOnClickListenner = this.buU.getOnSubCardOnClickListenner();
            kVar = this.buU.buM;
            onSubCardOnClickListenner.a(view, kVar);
        }
    }
}
