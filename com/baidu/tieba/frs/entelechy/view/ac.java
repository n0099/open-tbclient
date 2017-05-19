package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.card.cd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {
    final /* synthetic */ x bTG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(x xVar) {
        this.bTG = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bk bkVar;
        if (this.bTG.getOnSubCardOnClickListenner() != null) {
            cd<bk> onSubCardOnClickListenner = this.bTG.getOnSubCardOnClickListenner();
            bkVar = this.bTG.ahV;
            onSubCardOnClickListenner.a(view, bkVar);
        }
    }
}
