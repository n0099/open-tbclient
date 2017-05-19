package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {
    final /* synthetic */ al bvw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(al alVar) {
        this.bvw = alVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.l lVar;
        if (this.bvw.getOnSubCardOnClickListenner() != null) {
            cd<com.baidu.tieba.card.data.l> onSubCardOnClickListenner = this.bvw.getOnSubCardOnClickListenner();
            lVar = this.bvw.bvu;
            onSubCardOnClickListenner.a(view, lVar);
        }
    }
}
