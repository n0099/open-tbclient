package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements View.OnClickListener {
    final /* synthetic */ bc aTY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(bc bcVar) {
        this.aTY = bcVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.m mVar;
        if (this.aTY.KO() != null) {
            bx<com.baidu.tieba.card.a.m> KO = this.aTY.KO();
            mVar = this.aTY.aTN;
            KO.a(view, mVar);
        }
    }
}
