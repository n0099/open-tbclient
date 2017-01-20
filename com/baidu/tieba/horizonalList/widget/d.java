package com.baidu.tieba.horizonalList.widget;

import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    private final /* synthetic */ int Vn;
    final /* synthetic */ AbsHListView.j cCx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AbsHListView.j jVar, int i) {
        this.cCx = jVar;
        this.Vn = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cCx.kz(this.Vn);
    }
}
