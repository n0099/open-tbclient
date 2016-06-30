package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnClickListener {
    final /* synthetic */ z aTy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(z zVar) {
        this.aTy = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.o oVar;
        if (this.aTy.KO() != null) {
            bx<com.baidu.tieba.card.a.o> KO = this.aTy.KO();
            oVar = this.aTy.aTn;
            KO.a(view, oVar);
        }
    }
}
