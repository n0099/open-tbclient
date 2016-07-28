package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {
    final /* synthetic */ z aUu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(z zVar) {
        this.aUu = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.o oVar;
        com.baidu.tieba.card.a.o oVar2;
        oVar = this.aUu.aUj;
        if (oVar != null && this.aUu.KN() != null) {
            bx<com.baidu.tieba.card.a.o> KN = this.aUu.KN();
            oVar2 = this.aUu.aUj;
            KN.a(view, oVar2);
        }
    }
}
