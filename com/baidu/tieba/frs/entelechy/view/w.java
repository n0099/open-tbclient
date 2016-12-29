package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.card.cb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ t bGh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar) {
        this.bGh = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bg bgVar;
        if (this.bGh.getOnSubCardOnClickListenner() != null) {
            cb<bg> onSubCardOnClickListenner = this.bGh.getOnSubCardOnClickListenner();
            bgVar = this.bGh.adN;
            onSubCardOnClickListenner.a(view, bgVar);
        }
    }
}
