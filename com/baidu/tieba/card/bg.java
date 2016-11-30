package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements View.OnClickListener {
    final /* synthetic */ be bdL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(be beVar) {
        this.bdL = beVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.n nVar;
        if (this.bdL.getOnSubCardOnClickListenner() != null) {
            bz<com.baidu.tieba.card.data.n> onSubCardOnClickListenner = this.bdL.getOnSubCardOnClickListenner();
            nVar = this.bdL.bdH;
            onSubCardOnClickListenner.a(view, nVar);
        }
    }
}
