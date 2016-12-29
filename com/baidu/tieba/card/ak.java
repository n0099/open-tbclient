package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements View.OnClickListener {
    final /* synthetic */ ah bcB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ah ahVar) {
        this.bcB = ahVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.o oVar;
        if (this.bcB.getOnSubCardOnClickListenner() != null) {
            cb<com.baidu.tieba.card.data.o> onSubCardOnClickListenner = this.bcB.getOnSubCardOnClickListenner();
            oVar = this.bcB.bcy;
            onSubCardOnClickListenner.a(view, oVar);
        }
    }
}
