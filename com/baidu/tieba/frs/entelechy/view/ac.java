package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {
    final /* synthetic */ aa bMC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(aa aaVar) {
        this.bMC = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bh bhVar;
        if (this.bMC.getOnSubCardOnClickListenner() != null) {
            cf<bh> onSubCardOnClickListenner = this.bMC.getOnSubCardOnClickListenner();
            bhVar = this.bMC.acX;
            onSubCardOnClickListenner.a(view, bhVar);
        }
        this.bMC.Rt();
    }
}
