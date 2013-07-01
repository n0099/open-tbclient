package com.baidu.tieba.flist;

import android.support.v4.view.ViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends ViewPager.SimpleOnPageChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CoverFlow f812a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(CoverFlow coverFlow) {
        this.f812a = coverFlow;
    }

    @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.bq
    public void b(int i) {
        if (i == 0) {
            int currentItem = this.f812a.getCurrentItem();
            if (currentItem <= 1) {
                this.f812a.a((this.f812a.getAdapter().getCount() - 1) - 2, false);
                this.f812a.invalidate();
            } else if (currentItem >= this.f812a.getAdapter().getCount() - 2) {
                this.f812a.a(2, false);
                this.f812a.invalidate();
            }
        }
    }
}
