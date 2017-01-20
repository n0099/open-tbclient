package com.baidu.tieba.horizonalList.widget;

import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    private final /* synthetic */ int Vn;
    final /* synthetic */ AbsHListView.j cCx;
    private final /* synthetic */ int cCy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AbsHListView.j jVar, int i, int i2) {
        this.cCx = jVar;
        this.Vn = i;
        this.cCy = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cCx.az(this.Vn, this.cCy);
    }
}
