package com.baidu.tieba.im.friend;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements AbsListView.OnScrollListener {
    final /* synthetic */ u a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(u uVar) {
        this.a = uVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.a.e();
    }
}
