package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.card.cd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements View.OnClickListener {
    final /* synthetic */ as bUd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(as asVar) {
        this.bUd = asVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bk bkVar;
        if (this.bUd.getOnSubCardOnClickListenner() != null) {
            cd<bk> onSubCardOnClickListenner = this.bUd.getOnSubCardOnClickListenner();
            bkVar = this.bUd.ahV;
            onSubCardOnClickListenner.a(view, bkVar);
        }
    }
}
