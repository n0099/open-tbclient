package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements View.OnClickListener {
    final /* synthetic */ bd aQB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(bd bdVar) {
        this.aQB = bdVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.l lVar;
        if (this.aQB.JM() != null) {
            by<com.baidu.tieba.card.a.l> JM = this.aQB.JM();
            lVar = this.aQB.aQq;
            JM.a(view, lVar);
        }
        this.aQB.Kd();
    }
}
