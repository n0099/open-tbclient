package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements View.OnClickListener {
    final /* synthetic */ au aUO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(au auVar) {
        this.aUO = auVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.m mVar;
        if (this.aUO.KN() != null) {
            bx<com.baidu.tieba.card.a.m> KN = this.aUO.KN();
            mVar = this.aUO.aUJ;
            KN.a(view, mVar);
        }
        this.aUO.Lc();
    }
}
