package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements View.OnClickListener {
    final /* synthetic */ ah aZK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ah ahVar) {
        this.aZK = ahVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.o oVar;
        if (this.aZK.getOnSubCardOnClickListenner() != null) {
            cf<com.baidu.tieba.card.data.o> onSubCardOnClickListenner = this.aZK.getOnSubCardOnClickListenner();
            oVar = this.aZK.aZH;
            onSubCardOnClickListenner.a(view, oVar);
        }
    }
}
