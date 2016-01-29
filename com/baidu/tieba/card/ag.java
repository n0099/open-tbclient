package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {
    final /* synthetic */ af aQu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar) {
        this.aQu = afVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.q qVar;
        if (this.aQu.JL() != null) {
            bb<com.baidu.tieba.card.a.q> JL = this.aQu.JL();
            qVar = this.aQu.aQn;
            JL.a(view, qVar);
        }
        this.aQu.JX();
    }
}
