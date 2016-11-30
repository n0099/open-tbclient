package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.card.bz;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a cax;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.cax = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bk bkVar;
        bk bkVar2;
        bkVar = this.cax.aeu;
        if (bkVar != null && this.cax.getOnSubCardOnClickListenner() != null) {
            bz<bk> onSubCardOnClickListenner = this.cax.getOnSubCardOnClickListenner();
            bkVar2 = this.cax.aeu;
            onSubCardOnClickListenner.a(view, bkVar2);
        }
    }
}
