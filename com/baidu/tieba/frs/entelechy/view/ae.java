package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnClickListener {
    final /* synthetic */ aa bMC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(aa aaVar) {
        this.bMC = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bh bhVar;
        cf<bh> onSubCardOnClickListenner = this.bMC.getOnSubCardOnClickListenner();
        if (onSubCardOnClickListenner != null) {
            bhVar = this.bMC.acX;
            onSubCardOnClickListenner.a(view, bhVar);
        }
    }
}
