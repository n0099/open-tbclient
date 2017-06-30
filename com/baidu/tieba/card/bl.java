package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl implements View.OnClickListener {
    final /* synthetic */ bj bCC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bj bjVar) {
        this.bCC = bjVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.m mVar;
        if (this.bCC.Vs() != null) {
            ci<com.baidu.tieba.card.data.m> Vs = this.bCC.Vs();
            mVar = this.bCC.bCy;
            Vs.a(view, mVar);
        }
    }
}
