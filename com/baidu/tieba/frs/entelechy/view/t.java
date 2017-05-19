package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.card.cd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ q bTB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar) {
        this.bTB = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bk bkVar;
        if (this.bTB.getOnSubCardOnClickListenner() != null) {
            cd<bk> onSubCardOnClickListenner = this.bTB.getOnSubCardOnClickListenner();
            bkVar = this.bTB.ahV;
            onSubCardOnClickListenner.a(view, bkVar);
        }
    }
}
