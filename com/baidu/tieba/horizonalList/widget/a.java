package com.baidu.tieba.horizonalList.widget;

import android.view.View;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements Runnable {
    final /* synthetic */ AbsHListView bGu;
    private final /* synthetic */ View bGv;
    private final /* synthetic */ AbsHListView.i bGw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsHListView absHListView, View view, AbsHListView.i iVar) {
        this.bGu = absHListView;
        this.bGv = view;
        this.bGw = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bGu.mTouchMode = -1;
        this.bGv.setPressed(false);
        this.bGu.setPressed(false);
        if (!this.bGu.afI) {
            this.bGw.run();
        }
    }
}
