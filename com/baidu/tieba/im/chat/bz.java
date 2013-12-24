package com.baidu.tieba.im.chat;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz implements AbsListView.OnScrollListener {
    final /* synthetic */ bu a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(bu buVar) {
        this.a = buVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.a.K();
        this.a.L();
        this.a.M();
    }
}
