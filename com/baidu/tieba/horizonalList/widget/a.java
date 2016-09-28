package com.baidu.tieba.horizonalList.widget;

import android.view.View;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements Runnable {
    final /* synthetic */ AbsHListView cKE;
    private final /* synthetic */ View cKF;
    private final /* synthetic */ AbsHListView.i cKG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsHListView absHListView, View view, AbsHListView.i iVar) {
        this.cKE = absHListView;
        this.cKF = view;
        this.cKG = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cKE.mTouchMode = -1;
        this.cKF.setPressed(false);
        this.cKE.setPressed(false);
        if (!this.cKE.aeL) {
            this.cKG.run();
        }
    }
}
