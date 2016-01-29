package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnClickListener {
    final /* synthetic */ af aQu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(af afVar) {
        this.aQu = afVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.q qVar;
        bb<com.baidu.tieba.card.a.q> JL = this.aQu.JL();
        if (JL != null) {
            view.setTag("1");
            qVar = this.aQu.aQn;
            JL.a(view, qVar);
        }
    }
}
