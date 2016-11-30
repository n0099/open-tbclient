package com.baidu.tieba.card;

import android.view.View;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements com.baidu.tbadk.widget.layout.h {
    final /* synthetic */ ao bdA;
    private final /* synthetic */ LinkedList bdB;
    private final /* synthetic */ com.baidu.tbadk.core.data.bk bdC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(ao aoVar, LinkedList linkedList, com.baidu.tbadk.core.data.bk bkVar) {
        this.bdA = aoVar;
        this.bdB = linkedList;
        this.bdC = bkVar;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void c(View view, int i, boolean z) {
        com.baidu.tieba.card.data.m mVar;
        bz<com.baidu.tieba.card.data.m> onSubCardOnClickListenner = this.bdA.getOnSubCardOnClickListenner();
        if (onSubCardOnClickListenner != null) {
            view.setTag("1");
            mVar = this.bdA.bdv;
            onSubCardOnClickListenner.a(view, mVar);
        }
        if (!z) {
            this.bdA.a(this.bdB, i, this.bdC);
        } else {
            this.bdA.Ph();
        }
    }
}
