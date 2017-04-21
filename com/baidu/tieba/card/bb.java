package com.baidu.tieba.card;

import android.view.View;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements com.baidu.tbadk.widget.layout.g {
    final /* synthetic */ au bvM;
    private final /* synthetic */ LinkedList bvN;
    private final /* synthetic */ com.baidu.tbadk.core.data.bi bvO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(au auVar, LinkedList linkedList, com.baidu.tbadk.core.data.bi biVar) {
        this.bvM = auVar;
        this.bvN = linkedList;
        this.bvO = biVar;
    }

    @Override // com.baidu.tbadk.widget.layout.g
    public void c(View view, int i, boolean z) {
        com.baidu.tieba.card.data.n nVar;
        cf<com.baidu.tieba.card.data.n> onSubCardOnClickListenner = this.bvM.getOnSubCardOnClickListenner();
        if (onSubCardOnClickListenner != null) {
            view.setTag("1");
            nVar = this.bvM.bvH;
            onSubCardOnClickListenner.a(view, nVar);
        }
        if (!z) {
            this.bvM.a(this.bvN, i, this.bvO);
        } else {
            this.bvM.TR();
        }
    }
}
