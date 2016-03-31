package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements View.OnClickListener {
    final /* synthetic */ al aTK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(al alVar) {
        this.aTK = alVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.v vVar;
        com.baidu.tieba.card.a.v vVar2;
        vVar = this.aTK.aTD;
        if (vVar != null && this.aTK.Ld() != null) {
            cj<com.baidu.tieba.card.a.v> Ld = this.aTK.Ld();
            vVar2 = this.aTK.aTD;
            Ld.a(view, vVar2);
        }
    }
}
