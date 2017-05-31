package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements View.OnClickListener {
    final /* synthetic */ au bBu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(au auVar) {
        this.bBu = auVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.l lVar;
        if (this.bBu.Ud() != null) {
            ci<com.baidu.tieba.card.data.l> Ud = this.bBu.Ud();
            lVar = this.bBu.bzH;
            Ud.a(view, lVar);
        }
    }
}
