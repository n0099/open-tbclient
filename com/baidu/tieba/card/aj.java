package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnClickListener {
    final /* synthetic */ x bml;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(x xVar) {
        this.bml = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.p pVar;
        if (this.bml.getOnSubCardOnClickListenner() != null) {
            cf<com.baidu.tieba.card.data.p> onSubCardOnClickListenner = this.bml.getOnSubCardOnClickListenner();
            pVar = this.bml.bmd;
            onSubCardOnClickListenner.a(view, pVar);
        }
    }
}
