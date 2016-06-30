package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {
    final /* synthetic */ z aTy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(z zVar) {
        this.aTy = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.o oVar;
        com.baidu.tieba.card.a.o oVar2;
        oVar = this.aTy.aTn;
        if (oVar != null && this.aTy.KO() != null) {
            bx<com.baidu.tieba.card.a.o> KO = this.aTy.KO();
            oVar2 = this.aTy.aTn;
            KO.a(view, oVar2);
        }
    }
}
