package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements View.OnClickListener {
    final /* synthetic */ bp aUl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(bp bpVar) {
        this.aUl = bpVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.o oVar;
        com.baidu.tieba.card.a.o oVar2;
        oVar = this.aUl.aTn;
        if (oVar != null && this.aUl.KO() != null) {
            bx<com.baidu.tieba.card.a.o> KO = this.aUl.KO();
            oVar2 = this.aUl.aTn;
            KO.a(view, oVar2);
        }
    }
}
