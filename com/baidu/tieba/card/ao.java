package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {
    final /* synthetic */ am bBf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(am amVar) {
        this.bBf = amVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.n nVar;
        if (this.bBf.Ud() != null) {
            ci<com.baidu.tieba.card.data.n> Ud = this.bBf.Ud();
            nVar = this.bBf.bBc;
            Ud.a(view, nVar);
        }
    }
}
