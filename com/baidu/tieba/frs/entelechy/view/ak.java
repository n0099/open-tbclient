package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tieba.card.cd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements View.OnClickListener {
    final /* synthetic */ ai bTO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ai aiVar) {
        this.bTO = aiVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.aw awVar;
        if (this.bTO.getOnSubCardOnClickListenner() != null) {
            cd<com.baidu.tbadk.core.data.aw> onSubCardOnClickListenner = this.bTO.getOnSubCardOnClickListenner();
            awVar = this.bTO.bTM;
            onSubCardOnClickListenner.a(view, awVar);
        }
    }
}
