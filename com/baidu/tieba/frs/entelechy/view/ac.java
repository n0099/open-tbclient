package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {
    final /* synthetic */ aa bTK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(aa aaVar) {
        this.bTK = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bj bjVar;
        if (this.bTK.getOnSubCardOnClickListenner() != null) {
            cf<bj> onSubCardOnClickListenner = this.bTK.getOnSubCardOnClickListenner();
            bjVar = this.bTK.ain;
            onSubCardOnClickListenner.a(view, bjVar);
        }
        this.bTK.Sr();
    }
}
