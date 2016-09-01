package com.baidu.tieba.card;

import android.view.View;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements com.baidu.tbadk.widget.layout.h {
    private final /* synthetic */ LinkedList baa;
    private final /* synthetic */ com.baidu.tbadk.core.data.bg bab;
    final /* synthetic */ br bbb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(br brVar, LinkedList linkedList, com.baidu.tbadk.core.data.bg bgVar) {
        this.bbb = brVar;
        this.baa = linkedList;
        this.bab = bgVar;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void c(View view, int i, boolean z) {
        if (z) {
            this.bbb.NF();
        } else {
            this.bbb.a(this.baa, i, this.bab);
        }
    }
}
