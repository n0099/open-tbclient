package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements View.OnClickListener {
    final /* synthetic */ al aTK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(al alVar) {
        this.aTK = alVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.v vVar;
        if (this.aTK.Ld() != null) {
            cj<com.baidu.tieba.card.a.v> Ld = this.aTK.Ld();
            vVar = this.aTK.aTD;
            Ld.a(view, vVar);
        }
    }
}
