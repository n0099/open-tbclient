package com.baidu.tieba.horizonalList.widget;

import android.view.View;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements Runnable {
    final /* synthetic */ AbsHListView cBZ;
    private final /* synthetic */ View cCa;
    private final /* synthetic */ AbsHListView.i cCb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsHListView absHListView, View view, AbsHListView.i iVar) {
        this.cBZ = absHListView;
        this.cCa = view;
        this.cCb = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cBZ.cBg = -1;
        this.cCa.setPressed(false);
        this.cBZ.setPressed(false);
        if (!this.cBZ.ajq) {
            this.cCb.run();
        }
    }
}
