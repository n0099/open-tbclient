package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements View.OnClickListener {
    final /* synthetic */ aq aQm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(aq aqVar) {
        this.aQm = aqVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.l lVar;
        if (this.aQm.JO() != null) {
            by<com.baidu.tieba.card.a.l> JO = this.aQm.JO();
            lVar = this.aQm.aQl;
            JO.a(view, lVar);
        }
    }
}
