package com.baidu.tieba.card;

import android.view.View;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements com.baidu.tbadk.widget.layout.h {
    final /* synthetic */ ao baq;
    private final /* synthetic */ LinkedList bas;
    private final /* synthetic */ com.baidu.tbadk.core.data.bi bat;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(ao aoVar, LinkedList linkedList, com.baidu.tbadk.core.data.bi biVar) {
        this.baq = aoVar;
        this.bas = linkedList;
        this.bat = biVar;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void c(View view, int i, boolean z) {
        com.baidu.tieba.card.data.m mVar;
        cd<com.baidu.tieba.card.data.m> onSubCardOnClickListenner = this.baq.getOnSubCardOnClickListenner();
        if (onSubCardOnClickListenner != null) {
            view.setTag("1");
            mVar = this.baq.bal;
            onSubCardOnClickListenner.a(view, mVar);
        }
        if (!z) {
            this.baq.a(this.bas, i, this.bat);
        } else {
            this.baq.Of();
        }
    }
}
