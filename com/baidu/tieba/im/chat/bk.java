package com.baidu.tieba.im.chat;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bg f1531a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(bg bgVar) {
        this.f1531a = bgVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.f1531a.L();
        this.f1531a.M();
        this.f1531a.N();
    }
}
