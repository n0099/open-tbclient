package com.baidu.tieba.horizonalList.widget;

import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    private final /* synthetic */ int Sx;
    final /* synthetic */ AbsHListView.j cvM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AbsHListView.j jVar, int i) {
        this.cvM = jVar;
        this.Sx = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cvM.jG(this.Sx);
    }
}
