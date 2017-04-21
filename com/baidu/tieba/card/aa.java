package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ x bvq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(x xVar) {
        this.bvq = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.p pVar;
        com.baidu.tieba.card.data.p pVar2;
        pVar = this.bvq.bvi;
        if (pVar != null && this.bvq.getOnSubCardOnClickListenner() != null) {
            cf<com.baidu.tieba.card.data.p> onSubCardOnClickListenner = this.bvq.getOnSubCardOnClickListenner();
            pVar2 = this.bvq.bvi;
            onSubCardOnClickListenner.a(view, pVar2);
        }
    }
}
