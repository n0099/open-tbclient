package com.baidu.tieba.horizonalList.widget;

import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    private final /* synthetic */ int WS;
    final /* synthetic */ AbsHListView.j bRk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AbsHListView.j jVar, int i) {
        this.bRk = jVar;
        this.WS = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bRk.start(this.WS);
    }
}
