package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.card.cd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a bTA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bTA = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bk bkVar;
        bk bkVar2;
        bkVar = this.bTA.ahV;
        if (bkVar != null && this.bTA.getOnSubCardOnClickListenner() != null) {
            cd<bk> onSubCardOnClickListenner = this.bTA.getOnSubCardOnClickListenner();
            bkVar2 = this.bTA.ahV;
            onSubCardOnClickListenner.a(view, bkVar2);
        }
    }
}
