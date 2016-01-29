package com.baidu.tieba.horizonalList.widget;

import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    private final /* synthetic */ int YA;
    final /* synthetic */ AbsHListView.j bGN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AbsHListView.j jVar, int i) {
        this.bGN = jVar;
        this.YA = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bGN.start(this.YA);
    }
}
