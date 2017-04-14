package com.baidu.tieba.card;

import android.view.View;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements com.baidu.tbadk.widget.layout.g {
    private final /* synthetic */ LinkedList btv;
    private final /* synthetic */ com.baidu.tbadk.core.data.bi btw;
    final /* synthetic */ br buq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(br brVar, LinkedList linkedList, com.baidu.tbadk.core.data.bi biVar) {
        this.buq = brVar;
        this.btv = linkedList;
        this.btw = biVar;
    }

    @Override // com.baidu.tbadk.widget.layout.g
    public void c(View view, int i, boolean z) {
        if (z) {
            this.buq.SP();
        } else {
            this.buq.a(this.btv, i, this.btw);
        }
    }
}
