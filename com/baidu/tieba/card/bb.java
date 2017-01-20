package com.baidu.tieba.card;

import android.view.View;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements com.baidu.tbadk.widget.layout.h {
    final /* synthetic */ au bmH;
    private final /* synthetic */ LinkedList bmI;
    private final /* synthetic */ com.baidu.tbadk.core.data.bh bmJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(au auVar, LinkedList linkedList, com.baidu.tbadk.core.data.bh bhVar) {
        this.bmH = auVar;
        this.bmI = linkedList;
        this.bmJ = bhVar;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void c(View view, int i, boolean z) {
        com.baidu.tieba.card.data.n nVar;
        cf<com.baidu.tieba.card.data.n> onSubCardOnClickListenner = this.bmH.getOnSubCardOnClickListenner();
        if (onSubCardOnClickListenner != null) {
            view.setTag("1");
            nVar = this.bmH.bmC;
            onSubCardOnClickListenner.a(view, nVar);
        }
        if (!z) {
            this.bmH.a(this.bmI, i, this.bmJ);
        } else {
            this.bmH.Rt();
        }
    }
}
