package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a bTB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bTB = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bj bjVar;
        bj bjVar2;
        bjVar = this.bTB.ain;
        if (bjVar != null && this.bTB.getOnSubCardOnClickListenner() != null) {
            cf<bj> onSubCardOnClickListenner = this.bTB.getOnSubCardOnClickListenner();
            bjVar2 = this.bTB.ain;
            onSubCardOnClickListenner.a(view, bjVar2);
        }
    }
}
