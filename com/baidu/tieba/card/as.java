package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements View.OnClickListener {
    final /* synthetic */ ap aUB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ap apVar) {
        this.aUB = apVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.m mVar;
        if (this.aUB.KN() != null) {
            bx<com.baidu.tieba.card.a.m> KN = this.aUB.KN();
            mVar = this.aUB.aUA;
            KN.a(view, mVar);
        }
    }
}
