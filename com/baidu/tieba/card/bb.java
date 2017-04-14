package com.baidu.tieba.card;

import android.view.View;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements com.baidu.tbadk.widget.layout.g {
    final /* synthetic */ au btu;
    private final /* synthetic */ LinkedList btv;
    private final /* synthetic */ com.baidu.tbadk.core.data.bi btw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(au auVar, LinkedList linkedList, com.baidu.tbadk.core.data.bi biVar) {
        this.btu = auVar;
        this.btv = linkedList;
        this.btw = biVar;
    }

    @Override // com.baidu.tbadk.widget.layout.g
    public void c(View view, int i, boolean z) {
        com.baidu.tieba.card.data.n nVar;
        cf<com.baidu.tieba.card.data.n> onSubCardOnClickListenner = this.btu.getOnSubCardOnClickListenner();
        if (onSubCardOnClickListenner != null) {
            view.setTag("1");
            nVar = this.btu.btp;
            onSubCardOnClickListenner.a(view, nVar);
        }
        if (!z) {
            this.btu.a(this.btv, i, this.btw);
        } else {
            this.btu.SP();
        }
    }
}
