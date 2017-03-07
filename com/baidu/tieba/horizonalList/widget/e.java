package com.baidu.tieba.horizonalList.widget;

import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    private final /* synthetic */ int aay;
    final /* synthetic */ AbsHListView.j cDT;
    private final /* synthetic */ int cDU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AbsHListView.j jVar, int i, int i2) {
        this.cDT = jVar;
        this.aay = i;
        this.cDU = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cDT.aC(this.aay, this.cDU);
    }
}
