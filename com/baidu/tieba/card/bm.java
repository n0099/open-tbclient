package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class bm implements View.OnClickListener {
    final /* synthetic */ bl bau;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bl blVar) {
        this.bau = blVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.o oVar;
        if (this.bau.getOnSubCardOnClickListenner() != null) {
            cf<com.baidu.tieba.card.data.o> onSubCardOnClickListenner = this.bau.getOnSubCardOnClickListenner();
            oVar = this.bau.aZr;
            onSubCardOnClickListenner.a(view, oVar);
        }
    }
}
