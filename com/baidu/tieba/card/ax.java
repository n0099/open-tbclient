package com.baidu.tieba.card;

import android.view.View;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements com.baidu.tbadk.widget.layout.h {
    final /* synthetic */ aq aZZ;
    private final /* synthetic */ LinkedList baa;
    private final /* synthetic */ com.baidu.tbadk.core.data.bg bab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(aq aqVar, LinkedList linkedList, com.baidu.tbadk.core.data.bg bgVar) {
        this.aZZ = aqVar;
        this.baa = linkedList;
        this.bab = bgVar;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void c(View view, int i, boolean z) {
        com.baidu.tieba.card.data.m mVar;
        cf<com.baidu.tieba.card.data.m> onSubCardOnClickListenner = this.aZZ.getOnSubCardOnClickListenner();
        if (onSubCardOnClickListenner != null) {
            view.setTag("1");
            mVar = this.aZZ.aZU;
            onSubCardOnClickListenner.a(view, mVar);
        }
        if (!z) {
            this.aZZ.a(this.baa, i, this.bab);
        } else {
            this.aZZ.NF();
        }
    }
}
