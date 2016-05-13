package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements View.OnClickListener {
    final /* synthetic */ av aQv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(av avVar) {
        this.aQv = avVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.l lVar;
        if (this.aQv.JO() != null) {
            by<com.baidu.tieba.card.a.l> JO = this.aQv.JO();
            lVar = this.aQv.aQq;
            JO.a(view, lVar);
        }
    }
}
