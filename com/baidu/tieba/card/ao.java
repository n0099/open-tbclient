package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {
    final /* synthetic */ al aUz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(al alVar) {
        this.aUz = alVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.o oVar;
        if (this.aUz.KN() != null) {
            bx<com.baidu.tieba.card.a.o> KN = this.aUz.KN();
            oVar = this.aUz.aUw;
            KN.a(view, oVar);
        }
    }
}
