package com.baidu.tieba.card;

import android.view.View;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements com.baidu.tbadk.widget.layout.h {
    final /* synthetic */ au aUO;
    private final /* synthetic */ LinkedList aUP;
    private final /* synthetic */ com.baidu.tbadk.core.data.be aUQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(au auVar, LinkedList linkedList, com.baidu.tbadk.core.data.be beVar) {
        this.aUO = auVar;
        this.aUP = linkedList;
        this.aUQ = beVar;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void c(View view, int i, boolean z) {
        com.baidu.tieba.card.a.m mVar;
        bx<com.baidu.tieba.card.a.m> KN = this.aUO.KN();
        if (KN != null) {
            view.setTag("1");
            mVar = this.aUO.aUJ;
            KN.a(view, mVar);
        }
        if (!z) {
            this.aUO.a(this.aUP, i, this.aUQ);
        } else {
            this.aUO.Lc();
        }
    }
}
