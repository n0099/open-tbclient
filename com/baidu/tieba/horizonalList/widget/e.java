package com.baidu.tieba.horizonalList.widget;

import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    private final /* synthetic */ int WD;
    final /* synthetic */ AbsHListView.j cQn;
    private final /* synthetic */ int cQo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AbsHListView.j jVar, int i, int i2) {
        this.cQn = jVar;
        this.WD = i;
        this.cQo = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cQn.aE(this.WD, this.cQo);
    }
}
