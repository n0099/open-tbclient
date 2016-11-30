package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements View.OnClickListener {
    final /* synthetic */ af bdj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(af afVar) {
        this.bdj = afVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.o oVar;
        if (this.bdj.getOnSubCardOnClickListenner() != null) {
            bz<com.baidu.tieba.card.data.o> onSubCardOnClickListenner = this.bdj.getOnSubCardOnClickListenner();
            oVar = this.bdj.bdg;
            onSubCardOnClickListenner.a(view, oVar);
        }
    }
}
