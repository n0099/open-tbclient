package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements View.OnClickListener {
    final /* synthetic */ an aQz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(an anVar) {
        this.aQz = anVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.r rVar;
        if (this.aQz.JL() != null) {
            bb<com.baidu.tieba.card.a.r> JL = this.aQz.JL();
            rVar = this.aQz.aQv;
            JL.a(view, rVar);
        }
    }
}
