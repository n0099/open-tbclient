package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class bg implements View.OnClickListener {
    final /* synthetic */ bc bCx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(bc bcVar) {
        this.bCx = bcVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.l lVar;
        ci<com.baidu.tieba.card.data.l> Vs = this.bCx.Vs();
        if (Vs != null) {
            view.setTag("2");
            lVar = this.bCx.bAA;
            Vs.a(view, lVar);
        }
    }
}
