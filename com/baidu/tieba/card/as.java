package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements View.OnClickListener {
    final /* synthetic */ ap btm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ap apVar) {
        this.btm = apVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.n nVar;
        if (this.btm.getOnSubCardOnClickListenner() != null) {
            cf<com.baidu.tieba.card.data.n> onSubCardOnClickListenner = this.btm.getOnSubCardOnClickListenner();
            nVar = this.btm.btl;
            onSubCardOnClickListenner.a(view, nVar);
        }
    }
}
