package com.baidu.tieba.horizonalList.widget;

import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    private final /* synthetic */ int Tf;
    final /* synthetic */ AbsHListView.j cyB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AbsHListView.j jVar, int i) {
        this.cyB = jVar;
        this.Tf = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cyB.jM(this.Tf);
    }
}
