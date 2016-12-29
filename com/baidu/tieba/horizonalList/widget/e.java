package com.baidu.tieba.horizonalList.widget;

import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    private final /* synthetic */ int VX;
    final /* synthetic */ AbsHListView.j cvt;
    private final /* synthetic */ int cvu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AbsHListView.j jVar, int i, int i2) {
        this.cvt = jVar;
        this.VX = i;
        this.cvu = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cvt.az(this.VX, this.cvu);
    }
}
