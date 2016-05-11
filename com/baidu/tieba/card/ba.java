package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements View.OnClickListener {
    final /* synthetic */ av aQv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(av avVar) {
        this.aQv = avVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.l lVar;
        if (this.aQv.JM() != null) {
            by<com.baidu.tieba.card.a.l> JM = this.aQv.JM();
            lVar = this.aQv.aQq;
            JM.a(view, lVar);
        }
    }
}
