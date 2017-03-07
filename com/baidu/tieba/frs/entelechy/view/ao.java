package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.aw;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {
    final /* synthetic */ am bTS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(am amVar) {
        this.bTS = amVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aw awVar;
        if (this.bTS.getOnSubCardOnClickListenner() != null) {
            cf<aw> onSubCardOnClickListenner = this.bTS.getOnSubCardOnClickListenner();
            awVar = this.bTS.bTQ;
            onSubCardOnClickListenner.a(view, awVar);
        }
    }
}
