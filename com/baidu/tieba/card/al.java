package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnClickListener {
    final /* synthetic */ y bBb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(y yVar) {
        this.bBb = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.n nVar;
        if (this.bBb.Ud() != null) {
            ci<com.baidu.tieba.card.data.n> Ud = this.bBb.Ud();
            nVar = this.bBb.bAK;
            Ud.a(view, nVar);
        }
    }
}
