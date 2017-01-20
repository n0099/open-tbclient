package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements View.OnClickListener {
    final /* synthetic */ au bmH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(au auVar) {
        this.bmH = auVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.n nVar;
        if (this.bmH.getOnSubCardOnClickListenner() != null) {
            cf<com.baidu.tieba.card.data.n> onSubCardOnClickListenner = this.bmH.getOnSubCardOnClickListenner();
            nVar = this.bmH.bmC;
            onSubCardOnClickListenner.a(view, nVar);
        }
    }
}
