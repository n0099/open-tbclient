package com.baidu.tieba.horizonalList.widget;

import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ AbsHListView.j bDB;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AbsHListView.j jVar, int i) {
        this.bDB = jVar;
        this.val$position = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bDB.hA(this.val$position);
    }
}
