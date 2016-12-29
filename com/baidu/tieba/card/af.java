package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    final /* synthetic */ t bcw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(t tVar) {
        this.bcw = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.o oVar;
        if (this.bcw.getOnSubCardOnClickListenner() != null) {
            cb<com.baidu.tieba.card.data.o> onSubCardOnClickListenner = this.bcw.getOnSubCardOnClickListenner();
            oVar = this.bcw.bco;
            onSubCardOnClickListenner.a(view, oVar);
        }
    }
}
