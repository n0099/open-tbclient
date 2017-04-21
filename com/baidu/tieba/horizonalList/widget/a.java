package com.baidu.tieba.horizonalList.widget;

import android.view.View;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements Runnable {
    final /* synthetic */ AbsHListView cEq;
    private final /* synthetic */ View cEr;
    private final /* synthetic */ AbsHListView.i cEs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsHListView absHListView, View view, AbsHListView.i iVar) {
        this.cEq = absHListView;
        this.cEr = view;
        this.cEs = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cEq.cDx = -1;
        this.cEr.setPressed(false);
        this.cEq.setPressed(false);
        if (!this.cEq.ajr) {
            this.cEs.run();
        }
    }
}
