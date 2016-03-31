package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cb implements View.OnClickListener {
    final /* synthetic */ by aUv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(by byVar) {
        this.aUv = byVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.v vVar;
        com.baidu.tieba.card.a.v vVar2;
        vVar = this.aUv.aTD;
        if (vVar != null && this.aUv.Ld() != null) {
            cj<com.baidu.tieba.card.a.v> Ld = this.aUv.Ld();
            vVar2 = this.aUv.aTD;
            Ld.a(view, vVar2);
        }
    }
}
