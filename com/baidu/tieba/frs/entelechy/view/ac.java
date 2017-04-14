package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {
    final /* synthetic */ aa bTy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(aa aaVar) {
        this.bTy = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bi biVar;
        if (this.bTy.getOnSubCardOnClickListenner() != null) {
            cf<bi> onSubCardOnClickListenner = this.bTy.getOnSubCardOnClickListenner();
            biVar = this.bTy.aiB;
            onSubCardOnClickListenner.a(view, biVar);
        }
        this.bTy.SP();
    }
}
