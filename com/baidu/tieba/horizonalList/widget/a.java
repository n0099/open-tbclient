package com.baidu.tieba.horizonalList.widget;

import android.view.View;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements Runnable {
    final /* synthetic */ AbsHListView cCe;
    private final /* synthetic */ View cCf;
    private final /* synthetic */ AbsHListView.i cCg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsHListView absHListView, View view, AbsHListView.i iVar) {
        this.cCe = absHListView;
        this.cCf = view;
        this.cCg = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cCe.cBl = -1;
        this.cCf.setPressed(false);
        this.cCe.setPressed(false);
        if (!this.cCe.adN) {
            this.cCg.run();
        }
    }
}
