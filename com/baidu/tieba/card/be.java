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
        if (this.aQB.JO() != null) {
            by<com.baidu.tieba.card.a.l> JO = this.aQB.JO();
            lVar = this.aQB.aQq;
            JO.a(view, lVar);
        }
        this.aQB.Kf();
    }
}
