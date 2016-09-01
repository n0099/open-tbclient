package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements View.OnClickListener {
    final /* synthetic */ ah bXw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar) {
        this.bXw = ahVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.aq aqVar;
        if (this.bXw.getOnSubCardOnClickListenner() != null) {
            cf<com.baidu.tbadk.core.data.aq> onSubCardOnClickListenner = this.bXw.getOnSubCardOnClickListenner();
            aqVar = this.bXw.bXu;
            onSubCardOnClickListenner.a(view, aqVar);
        }
    }
}
