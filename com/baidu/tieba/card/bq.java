package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements View.OnClickListener {
    final /* synthetic */ bl aUh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bl blVar) {
        this.aUh = blVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.t tVar;
        cj<com.baidu.tieba.card.a.t> Ld = this.aUh.Ld();
        if (Ld != null) {
            view.setTag("2");
            tVar = this.aUh.aTW;
            Ld.a(view, tVar);
        }
    }
}
