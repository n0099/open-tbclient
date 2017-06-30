package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements View.OnClickListener {
    final /* synthetic */ ap bCd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ap apVar) {
        this.bCd = apVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.l lVar;
        if (this.bCd.Vs() != null) {
            ci<com.baidu.tieba.card.data.l> Vs = this.bCd.Vs();
            lVar = this.bCd.bCb;
            Vs.a(view, lVar);
        }
    }
}
