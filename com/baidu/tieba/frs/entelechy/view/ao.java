package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {
    final /* synthetic */ am bMK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(am amVar) {
        this.bMK = amVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.au auVar;
        if (this.bMK.getOnSubCardOnClickListenner() != null) {
            cf<com.baidu.tbadk.core.data.au> onSubCardOnClickListenner = this.bMK.getOnSubCardOnClickListenner();
            auVar = this.bMK.bMI;
            onSubCardOnClickListenner.a(view, auVar);
        }
    }
}
