package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.card.bz;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ a cax;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(a aVar) {
        this.cax = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bk bkVar;
        if (this.cax.getOnSubCardOnClickListenner() != null) {
            bz<bk> onSubCardOnClickListenner = this.cax.getOnSubCardOnClickListenner();
            bkVar = this.cax.aeu;
            onSubCardOnClickListenner.a(view, bkVar);
        }
    }
}
