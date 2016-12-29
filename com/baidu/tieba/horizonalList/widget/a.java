package com.baidu.tieba.horizonalList.widget;

import android.view.View;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements Runnable {
    final /* synthetic */ AbsHListView cva;
    private final /* synthetic */ View cvb;
    private final /* synthetic */ AbsHListView.i cvc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsHListView absHListView, View view, AbsHListView.i iVar) {
        this.cva = absHListView;
        this.cvb = view;
        this.cvc = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cva.cuh = -1;
        this.cvb.setPressed(false);
        this.cva.setPressed(false);
        if (!this.cva.aeC) {
            this.cvc.run();
        }
    }
}
