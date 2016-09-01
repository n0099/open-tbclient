package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    final /* synthetic */ t aZF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(t tVar) {
        this.aZF = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.o oVar;
        if (this.aZF.getOnSubCardOnClickListenner() != null) {
            cf<com.baidu.tieba.card.data.o> onSubCardOnClickListenner = this.aZF.getOnSubCardOnClickListenner();
            oVar = this.aZF.aZr;
            onSubCardOnClickListenner.a(view, oVar);
        }
    }
}
