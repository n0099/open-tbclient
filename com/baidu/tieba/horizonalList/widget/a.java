package com.baidu.tieba.horizonalList.widget;

import android.view.View;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements Runnable {
    final /* synthetic */ AbsHListView cyi;
    private final /* synthetic */ View cyj;
    private final /* synthetic */ AbsHListView.i cyk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsHListView absHListView, View view, AbsHListView.i iVar) {
        this.cyi = absHListView;
        this.cyj = view;
        this.cyk = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cyi.mTouchMode = -1;
        this.cyj.setPressed(false);
        this.cyi.setPressed(false);
        if (!this.cyi.abK) {
            this.cyk.run();
        }
    }
}
