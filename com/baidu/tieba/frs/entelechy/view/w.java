package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.card.cd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ t bXj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar) {
        this.bXj = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bi biVar;
        if (this.bXj.getOnSubCardOnClickListenner() != null) {
            cd<bi> onSubCardOnClickListenner = this.bXj.getOnSubCardOnClickListenner();
            biVar = this.bXj.adW;
            onSubCardOnClickListenner.a(view, biVar);
        }
    }
}
