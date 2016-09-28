package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnClickListener {
    final /* synthetic */ r aZW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(r rVar) {
        this.aZW = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.o oVar;
        if (this.aZW.getOnSubCardOnClickListenner() != null) {
            cd<com.baidu.tieba.card.data.o> onSubCardOnClickListenner = this.aZW.getOnSubCardOnClickListenner();
            oVar = this.aZW.aZM;
            onSubCardOnClickListenner.a(view, oVar);
        }
    }
}
