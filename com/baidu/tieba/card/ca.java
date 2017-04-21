package com.baidu.tieba.card;

import android.view.View;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements com.baidu.tbadk.widget.layout.g {
    private final /* synthetic */ LinkedList bvN;
    private final /* synthetic */ com.baidu.tbadk.core.data.bi bvO;
    final /* synthetic */ br bwI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(br brVar, LinkedList linkedList, com.baidu.tbadk.core.data.bi biVar) {
        this.bwI = brVar;
        this.bvN = linkedList;
        this.bvO = biVar;
    }

    @Override // com.baidu.tbadk.widget.layout.g
    public void c(View view, int i, boolean z) {
        if (z) {
            this.bwI.TR();
        } else {
            this.bwI.a(this.bvN, i, this.bvO);
        }
    }
}
