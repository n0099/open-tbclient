package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu implements View.OnClickListener {
    final /* synthetic */ bt aUm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(bt btVar) {
        this.aUm = btVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.u uVar;
        if (this.aUm.Ld() != null) {
            cj<com.baidu.tieba.card.a.u> Ld = this.aUm.Ld();
            uVar = this.aUm.aUi;
            Ld.a(view, uVar);
        }
    }
}
