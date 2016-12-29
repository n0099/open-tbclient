package com.baidu.tieba.horizonalList.widget;

import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    private final /* synthetic */ int VX;
    final /* synthetic */ AbsHListView.j cvt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AbsHListView.j jVar, int i) {
        this.cvt = jVar;
        this.VX = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cvt.jM(this.VX);
    }
}
