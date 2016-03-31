package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz implements View.OnClickListener {
    final /* synthetic */ by aUv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(by byVar) {
        this.aUv = byVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.v vVar;
        if (this.aUv.Ld() != null) {
            cj<com.baidu.tieba.card.a.v> Ld = this.aUv.Ld();
            vVar = this.aUv.aTD;
            Ld.a(view, vVar);
        }
    }
}
