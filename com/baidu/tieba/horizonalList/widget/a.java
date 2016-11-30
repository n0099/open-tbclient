package com.baidu.tieba.horizonalList.widget;

import android.view.View;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements Runnable {
    final /* synthetic */ AbsHListView cPU;
    private final /* synthetic */ View cPV;
    private final /* synthetic */ AbsHListView.i cPW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsHListView absHListView, View view, AbsHListView.i iVar) {
        this.cPU = absHListView;
        this.cPV = view;
        this.cPW = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cPU.cPb = -1;
        this.cPV.setPressed(false);
        this.cPU.setPressed(false);
        if (!this.cPU.afj) {
            this.cPW.run();
        }
    }
}
