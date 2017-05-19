package com.baidu.tieba.card;

import android.view.View;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements com.baidu.tbadk.widget.layout.g {
    final /* synthetic */ aq bvK;
    private final /* synthetic */ LinkedList bvL;
    private final /* synthetic */ com.baidu.tbadk.core.data.bk bvM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(aq aqVar, LinkedList linkedList, com.baidu.tbadk.core.data.bk bkVar) {
        this.bvK = aqVar;
        this.bvL = linkedList;
        this.bvM = bkVar;
    }

    @Override // com.baidu.tbadk.widget.layout.g
    public void c(View view, int i, boolean z) {
        com.baidu.tieba.card.data.l lVar;
        cd<com.baidu.tieba.card.data.l> onSubCardOnClickListenner = this.bvK.getOnSubCardOnClickListenner();
        if (onSubCardOnClickListenner != null) {
            view.setTag("1");
            lVar = this.bvK.bvE;
            onSubCardOnClickListenner.a(view, lVar);
        }
        if (!z) {
            this.bvK.a(this.bvL, i, this.bvM);
        } else {
            this.bvK.Tj();
        }
    }
}
