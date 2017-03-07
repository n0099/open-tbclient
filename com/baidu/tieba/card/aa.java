package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ x btf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(x xVar) {
        this.btf = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.p pVar;
        com.baidu.tieba.card.data.p pVar2;
        pVar = this.btf.bsX;
        if (pVar != null && this.btf.getOnSubCardOnClickListenner() != null) {
            cf<com.baidu.tieba.card.data.p> onSubCardOnClickListenner = this.btf.getOnSubCardOnClickListenner();
            pVar2 = this.btf.bsX;
            onSubCardOnClickListenner.a(view, pVar2);
        }
    }
}
