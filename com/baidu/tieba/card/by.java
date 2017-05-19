package com.baidu.tieba.card;

import android.view.View;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by implements com.baidu.tbadk.widget.layout.g {
    private final /* synthetic */ LinkedList bvL;
    private final /* synthetic */ com.baidu.tbadk.core.data.bk bvM;
    final /* synthetic */ bp bwH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bp bpVar, LinkedList linkedList, com.baidu.tbadk.core.data.bk bkVar) {
        this.bwH = bpVar;
        this.bvL = linkedList;
        this.bvM = bkVar;
    }

    @Override // com.baidu.tbadk.widget.layout.g
    public void c(View view, int i, boolean z) {
        if (z) {
            this.bwH.Tj();
        } else {
            this.bwH.a(this.bvL, i, this.bvM);
        }
    }
}
