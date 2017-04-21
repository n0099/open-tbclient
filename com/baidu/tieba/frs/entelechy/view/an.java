package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements View.OnClickListener {
    final /* synthetic */ am bVX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar) {
        this.bVX = amVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.av avVar;
        if (this.bVX.getOnSubCardOnClickListenner() != null) {
            cf<com.baidu.tbadk.core.data.av> onSubCardOnClickListenner = this.bVX.getOnSubCardOnClickListenner();
            avVar = this.bVX.bVV;
            onSubCardOnClickListenner.a(view, avVar);
        }
    }
}
