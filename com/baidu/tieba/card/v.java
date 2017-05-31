package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ t bAB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.bAB = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.k kVar;
        if (this.bAB.Ud() != null) {
            ci<com.baidu.tieba.card.data.k> Ud = this.bAB.Ud();
            kVar = this.bAB.bAy;
            Ud.a(view, kVar);
        }
    }
}
