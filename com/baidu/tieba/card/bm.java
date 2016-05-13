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
        if (this.aQG.JO() != null) {
            by<com.baidu.tieba.card.a.m> JO = this.aQG.JO();
            mVar = this.aQG.aQC;
            JO.a(view, mVar);
        }
    }
}
