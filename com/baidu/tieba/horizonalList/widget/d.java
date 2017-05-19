package com.baidu.tieba.horizonalList.widget;

import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    private final /* synthetic */ int aak;
    final /* synthetic */ AbsHListView.j cyT;
    private final /* synthetic */ int cyU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AbsHListView.j jVar, int i, int i2) {
        this.cyT = jVar;
        this.aak = i;
        this.cyU = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cyT.av(this.aak, this.cyU);
    }
}
