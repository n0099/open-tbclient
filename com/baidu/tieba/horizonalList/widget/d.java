package com.baidu.tieba.horizonalList.widget;

import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    private final /* synthetic */ int VV;
    final /* synthetic */ AbsHListView.j cKg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AbsHListView.j jVar, int i) {
        this.cKg = jVar;
        this.VV = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cKg.kp(this.VV);
    }
}
