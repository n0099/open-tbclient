package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class bo implements View.OnClickListener {
    final /* synthetic */ bl bau;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(bl blVar) {
        this.bau = blVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.o oVar;
        com.baidu.tieba.card.data.o oVar2;
        oVar = this.bau.aZr;
        if (oVar != null && this.bau.getOnSubCardOnClickListenner() != null) {
            cf<com.baidu.tieba.card.data.o> onSubCardOnClickListenner = this.bau.getOnSubCardOnClickListenner();
            oVar2 = this.bau.aZr;
            onSubCardOnClickListenner.a(view, oVar2);
        }
    }
}
