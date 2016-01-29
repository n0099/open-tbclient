package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements View.OnClickListener {
    final /* synthetic */ ar aQJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(ar arVar) {
        this.aQJ = arVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.s sVar;
        com.baidu.tieba.card.a.s sVar2;
        sVar = this.aQJ.aQI;
        if (sVar != null && this.aQJ.JL() != null) {
            bb<com.baidu.tieba.card.a.s> JL = this.aQJ.JL();
            sVar2 = this.aQJ.aQI;
            JL.a(view, sVar2);
        }
    }
}
