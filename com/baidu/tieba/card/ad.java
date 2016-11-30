package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnClickListener {
    final /* synthetic */ r bde;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(r rVar) {
        this.bde = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.o oVar;
        if (this.bde.getOnSubCardOnClickListenner() != null) {
            bz<com.baidu.tieba.card.data.o> onSubCardOnClickListenner = this.bde.getOnSubCardOnClickListenner();
            oVar = this.bde.bcW;
            onSubCardOnClickListenner.a(view, oVar);
        }
    }
}
