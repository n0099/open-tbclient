package com.baidu.tieba.horizonalList.widget;

import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    private final /* synthetic */ int aaP;
    final /* synthetic */ AbsHListView.j cEJ;
    private final /* synthetic */ int cEK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AbsHListView.j jVar, int i, int i2) {
        this.cEJ = jVar;
        this.aaP = i;
        this.cEK = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cEJ.aA(this.aaP, this.cEK);
    }
}
