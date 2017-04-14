package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ x bsX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(x xVar) {
        this.bsX = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.p pVar;
        com.baidu.tieba.card.data.p pVar2;
        pVar = this.bsX.bsP;
        if (pVar != null && this.bsX.getOnSubCardOnClickListenner() != null) {
            cf<com.baidu.tieba.card.data.p> onSubCardOnClickListenner = this.bsX.getOnSubCardOnClickListenner();
            pVar2 = this.bsX.bsP;
            onSubCardOnClickListenner.a(view, pVar2);
        }
    }
}
