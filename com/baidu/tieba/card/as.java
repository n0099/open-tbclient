package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements View.OnClickListener {
    final /* synthetic */ ap bBk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ap apVar) {
        this.bBk = apVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.l lVar;
        if (this.bBk.Ud() != null) {
            ci<com.baidu.tieba.card.data.l> Ud = this.bBk.Ud();
            lVar = this.bBk.bBi;
            Ud.a(view, lVar);
        }
    }
}
