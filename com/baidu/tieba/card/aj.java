package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnClickListener {
    final /* synthetic */ x btf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(x xVar) {
        this.btf = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.p pVar;
        if (this.btf.getOnSubCardOnClickListenner() != null) {
            cf<com.baidu.tieba.card.data.p> onSubCardOnClickListenner = this.btf.getOnSubCardOnClickListenner();
            pVar = this.btf.bsX;
            onSubCardOnClickListenner.a(view, pVar);
        }
    }
}
