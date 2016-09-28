package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class bm implements View.OnClickListener {
    final /* synthetic */ bj baL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bj bjVar) {
        this.baL = bjVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.o oVar;
        com.baidu.tieba.card.data.o oVar2;
        oVar = this.baL.aZM;
        if (oVar != null && this.baL.getOnSubCardOnClickListenner() != null) {
            cd<com.baidu.tieba.card.data.o> onSubCardOnClickListenner = this.baL.getOnSubCardOnClickListenner();
            oVar2 = this.baL.aZM;
            onSubCardOnClickListenner.a(view, oVar2);
        }
    }
}
