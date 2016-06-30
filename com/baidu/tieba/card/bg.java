package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements View.OnClickListener {
    final /* synthetic */ bc aTY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(bc bcVar) {
        this.aTY = bcVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.m mVar;
        bx<com.baidu.tieba.card.a.m> KO = this.aTY.KO();
        if (KO != null) {
            view.setTag("1");
            mVar = this.aTY.aTN;
            KO.a(view, mVar);
        }
    }
}
