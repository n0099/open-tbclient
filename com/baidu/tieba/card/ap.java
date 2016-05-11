package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements View.OnClickListener {
    final /* synthetic */ am aQk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(am amVar) {
        this.aQk = amVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.n nVar;
        if (this.aQk.JM() != null) {
            by<com.baidu.tieba.card.a.n> JM = this.aQk.JM();
            nVar = this.aQk.aQg;
            JM.a(view, nVar);
        }
    }
}
