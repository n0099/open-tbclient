package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements View.OnClickListener {
    final /* synthetic */ au bBu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(au auVar) {
        this.bBu = auVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.l lVar;
        ci<com.baidu.tieba.card.data.l> Ud = this.bBu.Ud();
        if (Ud != null) {
            view.setTag("2");
            lVar = this.bBu.bzH;
            Ud.a(view, lVar);
        }
    }
}
