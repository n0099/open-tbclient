package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class bg implements View.OnClickListener {
    final /* synthetic */ bc bBE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(bc bcVar) {
        this.bBE = bcVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.l lVar;
        ci<com.baidu.tieba.card.data.l> Ud = this.bBE.Ud();
        if (Ud != null) {
            view.setTag("2");
            lVar = this.bBE.bzH;
            Ud.a(view, lVar);
        }
    }
}
