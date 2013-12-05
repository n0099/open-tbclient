package com.baidu.tieba.home;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f1450a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(SearchActivity searchActivity) {
        this.f1450a = searchActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2 || i == 1) {
            com.baidu.adp.lib.h.g.a(this.f1450a, absListView);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
