package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn implements View.OnClickListener {
    final /* synthetic */ bj bBJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bj bjVar) {
        this.bBJ = bjVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.m mVar;
        if (this.bBJ.Ud() != null) {
            ci<com.baidu.tieba.card.data.m> Ud = this.bBJ.Ud();
            mVar = this.bBJ.bBF;
            Ud.a(view, mVar);
        }
    }
}
