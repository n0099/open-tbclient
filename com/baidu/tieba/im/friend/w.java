package com.baidu.tieba.im.friend;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements AbsListView.OnScrollListener {
    final /* synthetic */ t a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar) {
        this.a = tVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.a.e();
    }
}
