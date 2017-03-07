package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ a bTB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(a aVar) {
        this.bTB = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bj bjVar;
        if (this.bTB.getOnSubCardOnClickListenner() != null) {
            cf<bj> onSubCardOnClickListenner = this.bTB.getOnSubCardOnClickListenner();
            bjVar = this.bTB.ain;
            onSubCardOnClickListenner.a(view, bjVar);
        }
    }
}
