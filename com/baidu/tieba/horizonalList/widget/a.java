package com.baidu.tieba.horizonalList.widget;

import android.view.View;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements Runnable {
    final /* synthetic */ AbsHListView bRs;
    private final /* synthetic */ View bRt;
    private final /* synthetic */ AbsHListView.i bRu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsHListView absHListView, View view, AbsHListView.i iVar) {
        this.bRs = absHListView;
        this.bRt = view;
        this.bRu = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bRs.mTouchMode = -1;
        this.bRt.setPressed(false);
        this.bRs.setPressed(false);
        if (!this.bRs.aaG) {
            this.bRu.run();
        }
    }
}
