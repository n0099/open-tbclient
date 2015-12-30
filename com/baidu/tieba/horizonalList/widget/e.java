package com.baidu.tieba.horizonalList.widget;

import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ AbsHListView.j bDB;
    private final /* synthetic */ int bDC;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AbsHListView.j jVar, int i, int i2) {
        this.bDB = jVar;
        this.val$position = i;
        this.bDC = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bDB.aj(this.val$position, this.bDC);
    }
}
