package com.baidu.tieba.card;

import android.view.View;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cd implements com.baidu.tbadk.widget.layout.g {
    private final /* synthetic */ LinkedList bCo;
    private final /* synthetic */ com.baidu.tbadk.core.data.bm bCp;
    final /* synthetic */ bu bDl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(bu buVar, LinkedList linkedList, com.baidu.tbadk.core.data.bm bmVar) {
        this.bDl = buVar;
        this.bCo = linkedList;
        this.bCp = bmVar;
    }

    @Override // com.baidu.tbadk.widget.layout.g
    public void c(View view, int i, boolean z) {
        if (z) {
            this.bDl.VI();
        } else {
            this.bDl.a(this.bCo, i, this.bCp);
        }
    }
}
