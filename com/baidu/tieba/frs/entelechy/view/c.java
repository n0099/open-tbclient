package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.card.cd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a bTA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bTA = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bk bkVar;
        if (this.bTA.getOnSubCardOnClickListenner() != null) {
            cd<bk> onSubCardOnClickListenner = this.bTA.getOnSubCardOnClickListenner();
            bkVar = this.bTA.ahV;
            onSubCardOnClickListenner.a(view, bkVar);
        }
    }
}
