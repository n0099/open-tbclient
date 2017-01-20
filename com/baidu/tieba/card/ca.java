package com.baidu.tieba.card;

import android.view.View;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements com.baidu.tbadk.widget.layout.h {
    private final /* synthetic */ LinkedList bmI;
    private final /* synthetic */ com.baidu.tbadk.core.data.bh bmJ;
    final /* synthetic */ br bnD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(br brVar, LinkedList linkedList, com.baidu.tbadk.core.data.bh bhVar) {
        this.bnD = brVar;
        this.bmI = linkedList;
        this.bmJ = bhVar;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void c(View view, int i, boolean z) {
        if (z) {
            this.bnD.Rt();
        } else {
            this.bnD.a(this.bmI, i, this.bmJ);
        }
    }
}
