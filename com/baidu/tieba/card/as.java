package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements View.OnClickListener {
    final /* synthetic */ ap aTF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ap apVar) {
        this.aTF = apVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.m mVar;
        if (this.aTF.KO() != null) {
            bx<com.baidu.tieba.card.a.m> KO = this.aTF.KO();
            mVar = this.aTF.aTE;
            KO.a(view, mVar);
        }
    }
}
