package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements View.OnClickListener {
    final /* synthetic */ be baC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(be beVar) {
        this.baC = beVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.n nVar;
        if (this.baC.getOnSubCardOnClickListenner() != null) {
            cd<com.baidu.tieba.card.data.n> onSubCardOnClickListenner = this.baC.getOnSubCardOnClickListenner();
            nVar = this.baC.bay;
            onSubCardOnClickListenner.a(view, nVar);
        }
    }
}
