package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements View.OnClickListener {
    final /* synthetic */ bd aQB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(bd bdVar) {
        this.aQB = bdVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.l lVar;
        by<com.baidu.tieba.card.a.l> JM = this.aQB.JM();
        if (JM != null) {
            view.setTag("1");
            lVar = this.aQB.aQq;
            JM.a(view, lVar);
        }
    }
}
