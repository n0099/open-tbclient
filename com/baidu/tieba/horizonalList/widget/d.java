package com.baidu.tieba.horizonalList.widget;

import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    private final /* synthetic */ int aaO;
    final /* synthetic */ AbsHListView.j cCs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AbsHListView.j jVar, int i) {
        this.cCs = jVar;
        this.aaO = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cCs.ke(this.aaO);
    }
}
