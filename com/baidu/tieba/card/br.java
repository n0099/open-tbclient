package com.baidu.tieba.card;

import android.view.View;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements com.baidu.tbadk.widget.layout.h {
    private final /* synthetic */ LinkedList bas;
    private final /* synthetic */ com.baidu.tbadk.core.data.bi bat;
    final /* synthetic */ bp bbs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(bp bpVar, LinkedList linkedList, com.baidu.tbadk.core.data.bi biVar) {
        this.bbs = bpVar;
        this.bas = linkedList;
        this.bat = biVar;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void c(View view, int i, boolean z) {
        if (z) {
            this.bbs.Of();
        } else {
            this.bbs.a(this.bas, i, this.bat);
        }
    }
}
