package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tieba.card.cd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements View.OnClickListener {
    final /* synthetic */ ah bXr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar) {
        this.bXr = ahVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.as asVar;
        if (this.bXr.getOnSubCardOnClickListenner() != null) {
            cd<com.baidu.tbadk.core.data.as> onSubCardOnClickListenner = this.bXr.getOnSubCardOnClickListenner();
            asVar = this.bXr.bXp;
            onSubCardOnClickListenner.a(view, asVar);
        }
    }
}
