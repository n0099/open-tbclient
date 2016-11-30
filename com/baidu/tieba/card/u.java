package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ r bde;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(r rVar) {
        this.bde = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.o oVar;
        com.baidu.tieba.card.data.o oVar2;
        oVar = this.bde.bcW;
        if (oVar != null && this.bde.getOnSubCardOnClickListenner() != null) {
            bz<com.baidu.tieba.card.data.o> onSubCardOnClickListenner = this.bde.getOnSubCardOnClickListenner();
            oVar2 = this.bde.bcW;
            onSubCardOnClickListenner.a(view, oVar2);
        }
    }
}
