package com.baidu.tieba.horizonalList.widget;

import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    private final /* synthetic */ int aaO;
    final /* synthetic */ AbsHListView.j cCs;
    private final /* synthetic */ int cCt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AbsHListView.j jVar, int i, int i2) {
        this.cCs = jVar;
        this.aaO = i;
        this.cCt = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cCs.aA(this.aaO, this.cCt);
    }
}
