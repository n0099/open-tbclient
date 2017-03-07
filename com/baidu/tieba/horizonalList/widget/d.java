package com.baidu.tieba.horizonalList.widget;

import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    private final /* synthetic */ int aay;
    final /* synthetic */ AbsHListView.j cDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AbsHListView.j jVar, int i) {
        this.cDT = jVar;
        this.aay = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cDT.kd(this.aay);
    }
}
