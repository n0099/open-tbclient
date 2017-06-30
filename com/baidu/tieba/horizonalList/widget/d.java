package com.baidu.tieba.horizonalList.widget;

import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    private final /* synthetic */ int aak;
    final /* synthetic */ AbsHListView.j cMH;
    private final /* synthetic */ int cMI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AbsHListView.j jVar, int i, int i2) {
        this.cMH = jVar;
        this.aak = i;
        this.cMI = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cMH.aB(this.aak, this.cMI);
    }
}
