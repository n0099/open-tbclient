package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class bk implements View.OnClickListener {
    final /* synthetic */ bj baL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(bj bjVar) {
        this.baL = bjVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.o oVar;
        if (this.baL.getOnSubCardOnClickListenner() != null) {
            cd<com.baidu.tieba.card.data.o> onSubCardOnClickListenner = this.baL.getOnSubCardOnClickListenner();
            oVar = this.baL.aZM;
            onSubCardOnClickListenner.a(view, oVar);
        }
    }
}
