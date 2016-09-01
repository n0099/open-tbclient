package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements View.OnClickListener {
    final /* synthetic */ bg bak;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(bg bgVar) {
        this.bak = bgVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.n nVar;
        if (this.bak.getOnSubCardOnClickListenner() != null) {
            cf<com.baidu.tieba.card.data.n> onSubCardOnClickListenner = this.bak.getOnSubCardOnClickListenner();
            nVar = this.bak.bag;
            onSubCardOnClickListenner.a(view, nVar);
        }
    }
}
