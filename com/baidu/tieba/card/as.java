package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements View.OnClickListener {
    final /* synthetic */ ap bte;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ap apVar) {
        this.bte = apVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.n nVar;
        if (this.bte.getOnSubCardOnClickListenner() != null) {
            cf<com.baidu.tieba.card.data.n> onSubCardOnClickListenner = this.bte.getOnSubCardOnClickListenner();
            nVar = this.bte.btd;
            onSubCardOnClickListenner.a(view, nVar);
        }
    }
}
