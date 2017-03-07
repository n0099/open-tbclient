package com.baidu.tieba.horizonalList.widget;

import android.view.View;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements Runnable {
    final /* synthetic */ AbsHListView cDA;
    private final /* synthetic */ View cDB;
    private final /* synthetic */ AbsHListView.i cDC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsHListView absHListView, View view, AbsHListView.i iVar) {
        this.cDA = absHListView;
        this.cDB = view;
        this.cDC = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cDA.cCH = -1;
        this.cDB.setPressed(false);
        this.cDA.setPressed(false);
        if (!this.cDA.ajc) {
            this.cDC.run();
        }
    }
}
