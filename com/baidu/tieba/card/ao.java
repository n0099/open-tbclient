package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {
    final /* synthetic */ al aTD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(al alVar) {
        this.aTD = alVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.o oVar;
        if (this.aTD.KO() != null) {
            bx<com.baidu.tieba.card.a.o> KO = this.aTD.KO();
            oVar = this.aTD.aTA;
            KO.a(view, oVar);
        }
    }
}
