package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl implements View.OnClickListener {
    final /* synthetic */ bk aUZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bk bkVar) {
        this.aUZ = bkVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.n nVar;
        if (this.aUZ.KN() != null) {
            bx<com.baidu.tieba.card.a.n> KN = this.aUZ.KN();
            nVar = this.aUZ.aUV;
            KN.a(view, nVar);
        }
    }
}
