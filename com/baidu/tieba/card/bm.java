package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements View.OnClickListener {
    final /* synthetic */ bk bvX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bk bkVar) {
        this.bvX = bkVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.o oVar;
        if (this.bvX.getOnSubCardOnClickListenner() != null) {
            cf<com.baidu.tieba.card.data.o> onSubCardOnClickListenner = this.bvX.getOnSubCardOnClickListenner();
            oVar = this.bvX.bvT;
            onSubCardOnClickListenner.a(view, oVar);
        }
    }
}
