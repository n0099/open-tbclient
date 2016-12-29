package com.baidu.tieba.card;

import android.view.View;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements com.baidu.tbadk.widget.layout.h {
    final /* synthetic */ aq bcS;
    private final /* synthetic */ LinkedList bcT;
    private final /* synthetic */ com.baidu.tbadk.core.data.bg bcU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(aq aqVar, LinkedList linkedList, com.baidu.tbadk.core.data.bg bgVar) {
        this.bcS = aqVar;
        this.bcT = linkedList;
        this.bcU = bgVar;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void c(View view, int i, boolean z) {
        com.baidu.tieba.card.data.m mVar;
        cb<com.baidu.tieba.card.data.m> onSubCardOnClickListenner = this.bcS.getOnSubCardOnClickListenner();
        if (onSubCardOnClickListenner != null) {
            view.setTag("1");
            mVar = this.bcS.bcN;
            onSubCardOnClickListenner.a(view, mVar);
        }
        if (!z) {
            this.bcS.a(this.bcT, i, this.bcU);
        } else {
            this.bcS.OD();
        }
    }
}
