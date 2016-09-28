package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements View.OnClickListener {
    final /* synthetic */ af bab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(af afVar) {
        this.bab = afVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.o oVar;
        if (this.bab.getOnSubCardOnClickListenner() != null) {
            cd<com.baidu.tieba.card.data.o> onSubCardOnClickListenner = this.bab.getOnSubCardOnClickListenner();
            oVar = this.bab.aZY;
            onSubCardOnClickListenner.a(view, oVar);
        }
    }
}
