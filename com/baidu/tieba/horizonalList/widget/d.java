package com.baidu.tieba.horizonalList.widget;

import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    private final /* synthetic */ int WD;
    final /* synthetic */ AbsHListView.j cQn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AbsHListView.j jVar, int i) {
        this.cQn = jVar;
        this.WD = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cQn.kC(this.WD);
    }
}
