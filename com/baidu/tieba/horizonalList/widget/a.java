package com.baidu.tieba.horizonalList.widget;

import android.view.View;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements Runnable {
    final /* synthetic */ AbsHListView cyA;
    private final /* synthetic */ View cyB;
    private final /* synthetic */ AbsHListView.i cyC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsHListView absHListView, View view, AbsHListView.i iVar) {
        this.cyA = absHListView;
        this.cyB = view;
        this.cyC = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cyA.cxH = -1;
        this.cyB.setPressed(false);
        this.cyA.setPressed(false);
        if (!this.cyA.aiO) {
            this.cyC.run();
        }
    }
}
