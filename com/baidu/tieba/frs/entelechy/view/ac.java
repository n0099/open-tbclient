package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {
    final /* synthetic */ aa bVP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(aa aaVar) {
        this.bVP = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bi biVar;
        if (this.bVP.getOnSubCardOnClickListenner() != null) {
            cf<bi> onSubCardOnClickListenner = this.bVP.getOnSubCardOnClickListenner();
            biVar = this.bVP.aiC;
            onSubCardOnClickListenner.a(view, biVar);
        }
        this.bVP.TR();
    }
}
