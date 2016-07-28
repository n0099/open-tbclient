package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnClickListener {
    final /* synthetic */ z aUu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(z zVar) {
        this.aUu = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.o oVar;
        if (this.aUu.KN() != null) {
            bx<com.baidu.tieba.card.a.o> KN = this.aUu.KN();
            oVar = this.aUu.aUj;
            KN.a(view, oVar);
        }
    }
}
