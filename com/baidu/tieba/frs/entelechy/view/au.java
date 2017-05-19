package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.card.cd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements View.OnClickListener {
    final /* synthetic */ as bUd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(as asVar) {
        this.bUd = asVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bk bkVar;
        cd<bk> onSubCardOnClickListenner = this.bUd.getOnSubCardOnClickListenner();
        if (onSubCardOnClickListenner != null) {
            view.setTag("2");
            bkVar = this.bUd.ahV;
            onSubCardOnClickListenner.a(view, bkVar);
        }
    }
}
