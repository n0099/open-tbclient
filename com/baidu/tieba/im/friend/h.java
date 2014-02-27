package com.baidu.tieba.im.friend;

import android.widget.AbsListView;
/* loaded from: classes.dex */
final class h implements AbsListView.OnScrollListener {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.a = fVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        this.a.e();
    }
}
