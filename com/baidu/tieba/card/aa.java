package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ x bml;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(x xVar) {
        this.bml = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.p pVar;
        com.baidu.tieba.card.data.p pVar2;
        pVar = this.bml.bmd;
        if (pVar != null && this.bml.getOnSubCardOnClickListenner() != null) {
            cf<com.baidu.tieba.card.data.p> onSubCardOnClickListenner = this.bml.getOnSubCardOnClickListenner();
            pVar2 = this.bml.bmd;
            onSubCardOnClickListenner.a(view, pVar2);
        }
    }
}
