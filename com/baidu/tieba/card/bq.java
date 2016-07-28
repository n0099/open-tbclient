package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements View.OnClickListener {
    final /* synthetic */ bp aVh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bp bpVar) {
        this.aVh = bpVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.o oVar;
        if (this.aVh.KN() != null) {
            bx<com.baidu.tieba.card.a.o> KN = this.aVh.KN();
            oVar = this.aVh.aUj;
            KN.a(view, oVar);
        }
    }
}
