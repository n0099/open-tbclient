package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ t bTE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar) {
        this.bTE = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bj bjVar;
        if (this.bTE.getOnSubCardOnClickListenner() != null) {
            cf<bj> onSubCardOnClickListenner = this.bTE.getOnSubCardOnClickListenner();
            bjVar = this.bTE.ain;
            onSubCardOnClickListenner.a(view, bjVar);
        }
    }
}
