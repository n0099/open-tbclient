package com.baidu.tieba.horizonalList.widget;

import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    private final /* synthetic */ int Wf;
    final /* synthetic */ AbsHListView.j cKX;
    private final /* synthetic */ int cKY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AbsHListView.j jVar, int i, int i2) {
        this.cKX = jVar;
        this.Wf = i;
        this.cKY = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cKX.aD(this.Wf, this.cKY);
    }
}
