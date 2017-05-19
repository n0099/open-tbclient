package com.baidu.tieba.card;

import android.view.View;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements View.OnClickListener {
    final /* synthetic */ aq bvK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(aq aqVar) {
        this.bvK = aqVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ThreadGodReplyLayout threadGodReplyLayout;
        com.baidu.tieba.card.data.l lVar;
        if (this.bvK.getOnSubCardOnClickListenner() != null) {
            cd<com.baidu.tieba.card.data.l> onSubCardOnClickListenner = this.bvK.getOnSubCardOnClickListenner();
            lVar = this.bvK.bvE;
            onSubCardOnClickListenner.a(view, lVar);
        }
        aq aqVar = this.bvK;
        threadGodReplyLayout = this.bvK.bvD;
        aqVar.da(view == threadGodReplyLayout);
    }
}
