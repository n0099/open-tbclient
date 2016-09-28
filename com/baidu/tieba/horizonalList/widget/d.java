package com.baidu.tieba.horizonalList.widget;

import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    private final /* synthetic */ int Wf;
    final /* synthetic */ AbsHListView.j cKX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AbsHListView.j jVar, int i) {
        this.cKX = jVar;
        this.Wf = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cKX.kv(this.Wf);
    }
}
