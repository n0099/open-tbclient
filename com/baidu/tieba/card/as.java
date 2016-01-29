package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements View.OnClickListener {
    final /* synthetic */ ar aQJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ar arVar) {
        this.aQJ = arVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.s sVar;
        if (this.aQJ.JL() != null) {
            bb<com.baidu.tieba.card.a.s> JL = this.aQJ.JL();
            sVar = this.aQJ.aQI;
            JL.a(view, sVar);
        }
    }
}
