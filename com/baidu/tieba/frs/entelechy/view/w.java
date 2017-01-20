package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ t bMw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar) {
        this.bMw = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bh bhVar;
        if (this.bMw.getOnSubCardOnClickListenner() != null) {
            cf<bh> onSubCardOnClickListenner = this.bMw.getOnSubCardOnClickListenner();
            bhVar = this.bMw.acX;
            onSubCardOnClickListenner.a(view, bhVar);
        }
    }
}
