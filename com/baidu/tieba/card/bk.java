package com.baidu.tieba.card;

import android.view.View;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements com.baidu.tbadk.widget.layout.g {
    final /* synthetic */ bd aUb;
    private final /* synthetic */ LinkedList aUc;
    private final /* synthetic */ com.baidu.tbadk.core.data.as aUd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(bd bdVar, LinkedList linkedList, com.baidu.tbadk.core.data.as asVar) {
        this.aUb = bdVar;
        this.aUc = linkedList;
        this.aUd = asVar;
    }

    @Override // com.baidu.tbadk.widget.layout.g
    public void c(View view, int i, boolean z) {
        com.baidu.tieba.card.a.t tVar;
        cj<com.baidu.tieba.card.a.t> Ld = this.aUb.Ld();
        if (Ld != null) {
            view.setTag("1");
            tVar = this.aUb.aTW;
            Ld.a(view, tVar);
        }
        if (!z) {
            this.aUb.a(this.aUc, i, this.aUd);
        } else {
            this.aUb.Lu();
        }
    }
}
