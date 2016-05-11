package com.baidu.tieba.horizonalList.widget;

import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    private final /* synthetic */ int Sg;
    final /* synthetic */ AbsHListView.j bRL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AbsHListView.j jVar, int i) {
        this.bRL = jVar;
        this.Sg = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bRL.ii(this.Sg);
    }
}
