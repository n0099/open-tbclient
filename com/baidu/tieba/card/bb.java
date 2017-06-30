package com.baidu.tieba.card;

import android.view.View;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements com.baidu.tbadk.widget.layout.g {
    final /* synthetic */ au bCn;
    private final /* synthetic */ LinkedList bCo;
    private final /* synthetic */ com.baidu.tbadk.core.data.bm bCp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(au auVar, LinkedList linkedList, com.baidu.tbadk.core.data.bm bmVar) {
        this.bCn = auVar;
        this.bCo = linkedList;
        this.bCp = bmVar;
    }

    @Override // com.baidu.tbadk.widget.layout.g
    public void c(View view, int i, boolean z) {
        com.baidu.tieba.card.data.l lVar;
        ci<com.baidu.tieba.card.data.l> Vs = this.bCn.Vs();
        if (Vs != null) {
            view.setTag("1");
            lVar = this.bCn.bAA;
            Vs.a(view, lVar);
        }
        if (!z) {
            this.bCn.a(this.bCo, i, this.bCp);
        } else {
            this.bCn.VI();
        }
    }
}
