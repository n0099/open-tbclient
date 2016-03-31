package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements View.OnClickListener {
    final /* synthetic */ bd aUb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(bd bdVar) {
        this.aUb = bdVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.t tVar;
        cj<com.baidu.tieba.card.a.t> Ld = this.aUb.Ld();
        if (Ld != null) {
            view.setTag("2");
            tVar = this.aUb.aTW;
            Ld.a(view, tVar);
        }
    }
}
