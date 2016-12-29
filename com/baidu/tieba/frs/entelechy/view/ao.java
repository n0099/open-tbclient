package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tieba.card.cb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {
    final /* synthetic */ am bGv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(am amVar) {
        this.bGv = amVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.at atVar;
        if (this.bGv.getOnSubCardOnClickListenner() != null) {
            cb<com.baidu.tbadk.core.data.at> onSubCardOnClickListenner = this.bGv.getOnSubCardOnClickListenner();
            atVar = this.bGv.bGt;
            onSubCardOnClickListenner.a(view, atVar);
        }
    }
}
