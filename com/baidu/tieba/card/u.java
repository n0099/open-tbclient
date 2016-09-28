package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ r aZW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(r rVar) {
        this.aZW = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.o oVar;
        com.baidu.tieba.card.data.o oVar2;
        oVar = this.aZW.aZM;
        if (oVar != null && this.aZW.getOnSubCardOnClickListenner() != null) {
            cd<com.baidu.tieba.card.data.o> onSubCardOnClickListenner = this.aZW.getOnSubCardOnClickListenner();
            oVar2 = this.aZW.aZM;
            onSubCardOnClickListenner.a(view, oVar2);
        }
    }
}
