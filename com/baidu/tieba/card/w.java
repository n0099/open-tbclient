package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ t bcw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar) {
        this.bcw = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.o oVar;
        com.baidu.tieba.card.data.o oVar2;
        oVar = this.bcw.bco;
        if (oVar != null && this.bcw.getOnSubCardOnClickListenner() != null) {
            cb<com.baidu.tieba.card.data.o> onSubCardOnClickListenner = this.bcw.getOnSubCardOnClickListenner();
            oVar2 = this.bcw.bco;
            onSubCardOnClickListenner.a(view, oVar2);
        }
    }
}
