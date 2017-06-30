package com.baidu.tieba.card;

import android.view.View;
/* loaded from: classes.dex */
class bi implements View.OnClickListener {
    final /* synthetic */ bc bCx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(bc bcVar) {
        this.bCx = bcVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.l lVar;
        if (this.bCx.Vs() != null) {
            ci<com.baidu.tieba.card.data.l> Vs = this.bCx.Vs();
            lVar = this.bCx.bAA;
            Vs.a(view, lVar);
        }
    }
}
