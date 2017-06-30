package com.baidu.tieba.horizonalList.widget;

import android.view.View;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements Runnable {
    final /* synthetic */ AbsHListView cMo;
    private final /* synthetic */ View cMp;
    private final /* synthetic */ AbsHListView.i cMq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsHListView absHListView, View view, AbsHListView.i iVar) {
        this.cMo = absHListView;
        this.cMp = view;
        this.cMq = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cMo.mTouchMode = -1;
        this.cMp.setPressed(false);
        this.cMo.setPressed(false);
        if (!this.cMo.mDataChanged) {
            this.cMq.run();
        }
    }
}
