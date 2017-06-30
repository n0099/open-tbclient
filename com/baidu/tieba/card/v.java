package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ t bBu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.bBu = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.k kVar;
        if (this.bBu.Vs() != null) {
            ci<com.baidu.tieba.card.data.k> Vs = this.bBu.Vs();
            kVar = this.bBu.bBr;
            Vs.a(view, kVar);
        }
    }
}
