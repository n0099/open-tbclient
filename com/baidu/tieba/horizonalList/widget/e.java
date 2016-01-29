package com.baidu.tieba.horizonalList.widget;

import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    private final /* synthetic */ int YA;
    final /* synthetic */ AbsHListView.j bGN;
    private final /* synthetic */ int bGO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AbsHListView.j jVar, int i, int i2) {
        this.bGN = jVar;
        this.YA = i;
        this.bGO = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bGN.aj(this.YA, this.bGO);
    }
}
