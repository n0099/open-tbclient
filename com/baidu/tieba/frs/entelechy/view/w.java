package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ t bTs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar) {
        this.bTs = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bi biVar;
        if (this.bTs.getOnSubCardOnClickListenner() != null) {
            cf<bi> onSubCardOnClickListenner = this.bTs.getOnSubCardOnClickListenner();
            biVar = this.bTs.aiB;
            onSubCardOnClickListenner.a(view, biVar);
        }
    }
}
