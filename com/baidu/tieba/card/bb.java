package com.baidu.tieba.card;

import android.view.View;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements com.baidu.tbadk.widget.layout.h {
    final /* synthetic */ au aTS;
    private final /* synthetic */ LinkedList aTT;
    private final /* synthetic */ com.baidu.tbadk.core.data.az aTU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(au auVar, LinkedList linkedList, com.baidu.tbadk.core.data.az azVar) {
        this.aTS = auVar;
        this.aTT = linkedList;
        this.aTU = azVar;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void c(View view, int i, boolean z) {
        com.baidu.tieba.card.a.m mVar;
        bx<com.baidu.tieba.card.a.m> KO = this.aTS.KO();
        if (KO != null) {
            view.setTag("1");
            mVar = this.aTS.aTN;
            KO.a(view, mVar);
        }
        if (!z) {
            this.aTS.a(this.aTT, i, this.aTU);
        } else {
            this.aTS.Ld();
        }
    }
}
