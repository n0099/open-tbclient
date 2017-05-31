package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class bh implements View.OnClickListener {
    final /* synthetic */ bc bBE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(bc bcVar) {
        this.bBE = bcVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.l lVar;
        if (this.bBE.Ud() != null) {
            ci<com.baidu.tieba.card.data.l> Ud = this.bBE.Ud();
            lVar = this.bBE.bzH;
            Ud.a(view, lVar);
        }
    }
}
