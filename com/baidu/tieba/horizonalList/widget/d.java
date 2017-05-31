package com.baidu.tieba.horizonalList.widget;

import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    private final /* synthetic */ int aaj;
    final /* synthetic */ AbsHListView.j cEK;
    private final /* synthetic */ int cEL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AbsHListView.j jVar, int i, int i2) {
        this.cEK = jVar;
        this.aaj = i;
        this.cEL = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cEK.au(this.aaj, this.cEL);
    }
}
