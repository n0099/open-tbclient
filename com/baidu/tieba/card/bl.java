package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl implements View.OnClickListener {
    final /* synthetic */ bk bmS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bk bkVar) {
        this.bmS = bkVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.o oVar;
        if (this.bmS.getOnSubCardOnClickListenner() != null) {
            cf<com.baidu.tieba.card.data.o> onSubCardOnClickListenner = this.bmS.getOnSubCardOnClickListenner();
            oVar = this.bmS.bmO;
            onSubCardOnClickListenner.a(view, oVar);
        }
    }
}
