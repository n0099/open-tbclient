package com.baidu.tieba.horizonalList.widget;

import android.view.View;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements Runnable {
    final /* synthetic */ AbsHListView cEr;
    private final /* synthetic */ View cEs;
    private final /* synthetic */ AbsHListView.i cEt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsHListView absHListView, View view, AbsHListView.i iVar) {
        this.cEr = absHListView;
        this.cEs = view;
        this.cEt = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cEr.mTouchMode = -1;
        this.cEs.setPressed(false);
        this.cEr.setPressed(false);
        if (!this.cEr.mDataChanged) {
            this.cEt.run();
        }
    }
}
