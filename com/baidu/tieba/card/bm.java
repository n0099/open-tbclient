package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements View.OnClickListener {
    final /* synthetic */ bk btN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bk bkVar) {
        this.btN = bkVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.o oVar;
        if (this.btN.getOnSubCardOnClickListenner() != null) {
            cf<com.baidu.tieba.card.data.o> onSubCardOnClickListenner = this.btN.getOnSubCardOnClickListenner();
            oVar = this.btN.btJ;
            onSubCardOnClickListenner.a(view, oVar);
        }
    }
}
