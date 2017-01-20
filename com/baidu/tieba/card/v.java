package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ t blS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.blS = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.m mVar;
        if (this.blS.getOnSubCardOnClickListenner() != null) {
            cf<com.baidu.tieba.card.data.m> onSubCardOnClickListenner = this.blS.getOnSubCardOnClickListenner();
            mVar = this.blS.blL;
            onSubCardOnClickListenner.a(view, mVar);
        }
    }
}
