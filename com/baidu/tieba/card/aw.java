package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements View.OnClickListener {
    final /* synthetic */ aq bvK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(aq aqVar) {
        this.bvK = aqVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.l lVar;
        if (this.bvK.getOnSubCardOnClickListenner() != null) {
            cd<com.baidu.tieba.card.data.l> onSubCardOnClickListenner = this.bvK.getOnSubCardOnClickListenner();
            lVar = this.bvK.bvE;
            onSubCardOnClickListenner.a(view, lVar);
        }
    }
}
