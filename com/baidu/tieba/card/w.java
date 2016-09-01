package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ t aZF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar) {
        this.aZF = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.o oVar;
        com.baidu.tieba.card.data.o oVar2;
        oVar = this.aZF.aZr;
        if (oVar != null && this.aZF.getOnSubCardOnClickListenner() != null) {
            cf<com.baidu.tieba.card.data.o> onSubCardOnClickListenner = this.aZF.getOnSubCardOnClickListenner();
            oVar2 = this.aZF.aZr;
            onSubCardOnClickListenner.a(view, oVar2);
        }
    }
}
