package com.baidu.tieba.card;

import android.view.View;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements com.baidu.tbadk.widget.layout.h {
    final /* synthetic */ au btC;
    private final /* synthetic */ LinkedList btD;
    private final /* synthetic */ com.baidu.tbadk.core.data.bj btE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(au auVar, LinkedList linkedList, com.baidu.tbadk.core.data.bj bjVar) {
        this.btC = auVar;
        this.btD = linkedList;
        this.btE = bjVar;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void c(View view, int i, boolean z) {
        com.baidu.tieba.card.data.n nVar;
        cf<com.baidu.tieba.card.data.n> onSubCardOnClickListenner = this.btC.getOnSubCardOnClickListenner();
        if (onSubCardOnClickListenner != null) {
            view.setTag("1");
            nVar = this.btC.btx;
            onSubCardOnClickListenner.a(view, nVar);
        }
        if (!z) {
            this.btC.a(this.btD, i, this.btE);
        } else {
            this.btC.Sr();
        }
    }
}
