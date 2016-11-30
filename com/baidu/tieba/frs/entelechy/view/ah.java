package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tieba.card.bz;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ ag caH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar) {
        this.caH = agVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.au auVar;
        if (this.caH.getOnSubCardOnClickListenner() != null) {
            bz<com.baidu.tbadk.core.data.au> onSubCardOnClickListenner = this.caH.getOnSubCardOnClickListenner();
            auVar = this.caH.caF;
            onSubCardOnClickListenner.a(view, auVar);
        }
    }
}
