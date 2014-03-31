package com.baidu.tieba.frs;

import android.app.Activity;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cs implements Runnable {
    final /* synthetic */ cm a;
    private final /* synthetic */ int b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(cm cmVar, int i, int i2) {
        this.a = cmVar;
        this.b = i;
        this.c = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BdListView bdListView;
        BdListView bdListView2;
        NavigationBar navigationBar;
        com.baidu.tbadk.a aVar;
        BdListView bdListView3;
        int[] iArr = new int[2];
        this.a.c.getLocationInWindow(iArr);
        bdListView = this.a.q;
        int i = this.b;
        bdListView2 = this.a.q;
        int headerViewsCount = i + bdListView2.getHeaderViewsCount();
        int i2 = iArr[1] - this.c;
        navigationBar = this.a.ad;
        int height = i2 - navigationBar.getHeight();
        aVar = this.a.f;
        bdListView.setSelectionFromTop(headerViewsCount, height - com.baidu.adp.lib.util.i.a((Activity) aVar));
        bdListView3 = this.a.q;
        bdListView3.invalidate();
    }
}
