package com.baidu.tieba.horizonalList.widget;

import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    private final /* synthetic */ int WS;
    final /* synthetic */ AbsHListView.j bRk;
    private final /* synthetic */ int bRl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AbsHListView.j jVar, int i, int i2) {
        this.bRk = jVar;
        this.WS = i;
        this.bRl = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bRk.ag(this.WS, this.bRl);
    }
}
