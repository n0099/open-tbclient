package com.baidu.tieba.im.chat;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bm f1575a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bm bmVar) {
        this.f1575a = bmVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.f1575a.J();
        this.f1575a.K();
        this.f1575a.L();
    }
}
