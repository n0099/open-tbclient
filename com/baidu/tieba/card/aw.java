package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements View.OnClickListener {
    final /* synthetic */ aq aZZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(aq aqVar) {
        this.aZZ = aqVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.m mVar;
        if (this.aZZ.getOnSubCardOnClickListenner() != null) {
            cf<com.baidu.tieba.card.data.m> onSubCardOnClickListenner = this.aZZ.getOnSubCardOnClickListenner();
            mVar = this.aZZ.aZU;
            onSubCardOnClickListenner.a(view, mVar);
        }
    }
}
