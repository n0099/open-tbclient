package com.baidu.tieba.horizonalList.widget;

import android.view.View;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements Runnable {
    final /* synthetic */ AbsHListView bQR;
    private final /* synthetic */ View bQS;
    private final /* synthetic */ AbsHListView.i bQT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsHListView absHListView, View view, AbsHListView.i iVar) {
        this.bQR = absHListView;
        this.bQS = view;
        this.bQT = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bQR.mTouchMode = -1;
        this.bQS.setPressed(false);
        this.bQR.setPressed(false);
        if (!this.bQR.afh) {
            this.bQT.run();
        }
    }
}
