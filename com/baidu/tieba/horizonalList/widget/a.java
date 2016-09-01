package com.baidu.tieba.horizonalList.widget;

import android.view.View;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements Runnable {
    final /* synthetic */ AbsHListView cJN;
    private final /* synthetic */ View cJO;
    private final /* synthetic */ AbsHListView.i cJP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsHListView absHListView, View view, AbsHListView.i iVar) {
        this.cJN = absHListView;
        this.cJO = view;
        this.cJP = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cJN.mTouchMode = -1;
        this.cJO.setPressed(false);
        this.cJN.setPressed(false);
        if (!this.cJN.aeA) {
            this.cJP.run();
        }
    }
}
