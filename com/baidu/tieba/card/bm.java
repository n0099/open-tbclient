package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements View.OnClickListener {
    final /* synthetic */ bk btF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bk bkVar) {
        this.btF = bkVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.o oVar;
        if (this.btF.getOnSubCardOnClickListenner() != null) {
            cf<com.baidu.tieba.card.data.o> onSubCardOnClickListenner = this.btF.getOnSubCardOnClickListenner();
            oVar = this.btF.btB;
            onSubCardOnClickListenner.a(view, oVar);
        }
    }
}
