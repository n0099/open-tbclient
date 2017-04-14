package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnClickListener {
    final /* synthetic */ aa bTy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(aa aaVar) {
        this.bTy = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bi biVar;
        cf<bi> onSubCardOnClickListenner = this.bTy.getOnSubCardOnClickListenner();
        if (onSubCardOnClickListenner != null) {
            biVar = this.bTy.aiB;
            onSubCardOnClickListenner.a(view, biVar);
        }
    }
}
