package com.baidu.tieba.horizonalList.widget;

import android.view.View;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements Runnable {
    final /* synthetic */ AbsHListView bDi;
    private final /* synthetic */ View bDj;
    private final /* synthetic */ AbsHListView.i bDk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsHListView absHListView, View view, AbsHListView.i iVar) {
        this.bDi = absHListView;
        this.bDj = view;
        this.bDk = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bDi.mTouchMode = -1;
        this.bDj.setPressed(false);
        this.bDi.setPressed(false);
        if (!this.bDi.aeW) {
            this.bDk.run();
        }
    }
}
