package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements View.OnClickListener {
    final /* synthetic */ bl aQG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bl blVar) {
        this.aQG = blVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.m mVar;
        if (this.aQG.JM() != null) {
            by<com.baidu.tieba.card.a.m> JM = this.aQG.JM();
            mVar = this.aQG.aQC;
            JM.a(view, mVar);
        }
    }
}
