package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {
    final /* synthetic */ al bmq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(al alVar) {
        this.bmq = alVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.p pVar;
        if (this.bmq.getOnSubCardOnClickListenner() != null) {
            cf<com.baidu.tieba.card.data.p> onSubCardOnClickListenner = this.bmq.getOnSubCardOnClickListenner();
            pVar = this.bmq.bmn;
            onSubCardOnClickListenner.a(view, pVar);
        }
    }
}
