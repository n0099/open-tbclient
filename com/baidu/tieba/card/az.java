package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements View.OnClickListener {
    final /* synthetic */ au btu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(au auVar) {
        this.btu = auVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.n nVar;
        if (this.btu.getOnSubCardOnClickListenner() != null) {
            cf<com.baidu.tieba.card.data.n> onSubCardOnClickListenner = this.btu.getOnSubCardOnClickListenner();
            nVar = this.btu.btp;
            onSubCardOnClickListenner.a(view, nVar);
        }
    }
}
