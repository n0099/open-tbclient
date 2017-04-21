package com.baidu.tieba.horizonalList.widget;

import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    private final /* synthetic */ int aaP;
    final /* synthetic */ AbsHListView.j cEJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AbsHListView.j jVar, int i) {
        this.cEJ = jVar;
        this.aaP = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cEJ.kk(this.aaP);
    }
}
