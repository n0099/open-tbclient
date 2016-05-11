package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements View.OnClickListener {
    final /* synthetic */ av aQv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(av avVar) {
        this.aQv = avVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.l lVar;
        by<com.baidu.tieba.card.a.l> JM = this.aQv.JM();
        if (JM != null) {
            view.setTag("2");
            lVar = this.aQv.aQq;
            JM.a(view, lVar);
        }
    }
}
