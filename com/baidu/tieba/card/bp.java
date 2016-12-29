package com.baidu.tieba.card;

import android.view.View;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp implements com.baidu.tbadk.widget.layout.h {
    private final /* synthetic */ LinkedList bcT;
    private final /* synthetic */ com.baidu.tbadk.core.data.bg bcU;
    final /* synthetic */ bn bdP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(bn bnVar, LinkedList linkedList, com.baidu.tbadk.core.data.bg bgVar) {
        this.bdP = bnVar;
        this.bcT = linkedList;
        this.bcU = bgVar;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void c(View view, int i, boolean z) {
        if (z) {
            this.bdP.OD();
        } else {
            this.bdP.a(this.bcT, i, this.bcU);
        }
    }
}
