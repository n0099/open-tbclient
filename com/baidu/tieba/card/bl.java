package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl implements View.OnClickListener {
    final /* synthetic */ bk aUd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bk bkVar) {
        this.aUd = bkVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.n nVar;
        if (this.aUd.KO() != null) {
            bx<com.baidu.tieba.card.a.n> KO = this.aUd.KO();
            nVar = this.aUd.aTZ;
            KO.a(view, nVar);
        }
    }
}
