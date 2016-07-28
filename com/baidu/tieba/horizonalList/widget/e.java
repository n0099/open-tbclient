package com.baidu.tieba.horizonalList.widget;

import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    private final /* synthetic */ int Tf;
    final /* synthetic */ AbsHListView.j cyB;
    private final /* synthetic */ int cyC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AbsHListView.j jVar, int i, int i2) {
        this.cyB = jVar;
        this.Tf = i;
        this.cyC = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cyB.ay(this.Tf, this.cyC);
    }
}
