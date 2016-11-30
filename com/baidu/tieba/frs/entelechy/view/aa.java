package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.card.bz;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ w caE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(w wVar) {
        this.caE = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bk bkVar;
        bz<bk> onSubCardOnClickListenner = this.caE.getOnSubCardOnClickListenner();
        if (onSubCardOnClickListenner != null) {
            bkVar = this.caE.aeu;
            onSubCardOnClickListenner.a(view, bkVar);
        }
    }
}
