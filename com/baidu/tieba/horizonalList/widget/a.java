package com.baidu.tieba.horizonalList.widget;

import android.view.View;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements Runnable {
    final /* synthetic */ AbsHListView cvt;
    private final /* synthetic */ View cvu;
    private final /* synthetic */ AbsHListView.i cvv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsHListView absHListView, View view, AbsHListView.i iVar) {
        this.cvt = absHListView;
        this.cvu = view;
        this.cvv = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cvt.mTouchMode = -1;
        this.cvu.setPressed(false);
        this.cvt.setPressed(false);
        if (!this.cvt.aaZ) {
            this.cvv.run();
        }
    }
}
