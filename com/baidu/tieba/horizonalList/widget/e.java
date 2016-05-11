package com.baidu.tieba.horizonalList.widget;

import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    private final /* synthetic */ int Sg;
    final /* synthetic */ AbsHListView.j bRL;
    private final /* synthetic */ int bRM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AbsHListView.j jVar, int i, int i2) {
        this.bRL = jVar;
        this.Sg = i;
        this.bRM = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bRL.af(this.Sg, this.bRM);
    }
}
