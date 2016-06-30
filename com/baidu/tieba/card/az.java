package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements View.OnClickListener {
    final /* synthetic */ au aTS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(au auVar) {
        this.aTS = auVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.m mVar;
        if (this.aTS.KO() != null) {
            bx<com.baidu.tieba.card.a.m> KO = this.aTS.KO();
            mVar = this.aTS.aTN;
            KO.a(view, mVar);
        }
    }
}
