package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements View.OnClickListener {
    final /* synthetic */ aq bcS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(aq aqVar) {
        this.bcS = aqVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.m mVar;
        if (this.bcS.getOnSubCardOnClickListenner() != null) {
            cb<com.baidu.tieba.card.data.m> onSubCardOnClickListenner = this.bcS.getOnSubCardOnClickListenner();
            mVar = this.bcS.bcN;
            onSubCardOnClickListenner.a(view, mVar);
        }
    }
}
