package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements View.OnClickListener {
    final /* synthetic */ au bCn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(au auVar) {
        this.bCn = auVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.l lVar;
        ci<com.baidu.tieba.card.data.l> Vs = this.bCn.Vs();
        if (Vs != null) {
            view.setTag("2");
            lVar = this.bCn.bAA;
            Vs.a(view, lVar);
        }
    }
}
