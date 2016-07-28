package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements View.OnClickListener {
    final /* synthetic */ bc aUU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(bc bcVar) {
        this.aUU = bcVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.m mVar;
        if (this.aUU.KN() != null) {
            bx<com.baidu.tieba.card.a.m> KN = this.aUU.KN();
            mVar = this.aUU.aUJ;
            KN.a(view, mVar);
        }
    }
}
