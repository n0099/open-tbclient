package com.baidu.tieba.card;

import android.view.View;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements com.baidu.tbadk.widget.layout.h {
    private final /* synthetic */ LinkedList btD;
    private final /* synthetic */ com.baidu.tbadk.core.data.bj btE;
    final /* synthetic */ br buz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(br brVar, LinkedList linkedList, com.baidu.tbadk.core.data.bj bjVar) {
        this.buz = brVar;
        this.btD = linkedList;
        this.btE = bjVar;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void c(View view, int i, boolean z) {
        if (z) {
            this.buz.Sr();
        } else {
            this.buz.a(this.btD, i, this.btE);
        }
    }
}
