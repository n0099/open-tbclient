package com.baidu.tieba.card;

import android.view.View;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn implements com.baidu.tbadk.widget.layout.h {
    private final /* synthetic */ LinkedList bdB;
    private final /* synthetic */ com.baidu.tbadk.core.data.bk bdC;
    final /* synthetic */ bl bey;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bl blVar, LinkedList linkedList, com.baidu.tbadk.core.data.bk bkVar) {
        this.bey = blVar;
        this.bdB = linkedList;
        this.bdC = bkVar;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void c(View view, int i, boolean z) {
        if (z) {
            this.bey.Ph();
        } else {
            this.bey.a(this.bdB, i, this.bdC);
        }
    }
}
