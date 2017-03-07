package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements View.OnClickListener {
    final /* synthetic */ au btC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(au auVar) {
        this.btC = auVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.n nVar;
        if (this.btC.getOnSubCardOnClickListenner() != null) {
            cf<com.baidu.tieba.card.data.n> onSubCardOnClickListenner = this.btC.getOnSubCardOnClickListenner();
            nVar = this.btC.btx;
            onSubCardOnClickListenner.a(view, nVar);
        }
    }
}
