package com.baidu.tieba.flist;

import android.support.v4.view.ViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends ViewPager.SimpleOnPageChangeListener {
    final /* synthetic */ CoverFlow a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(CoverFlow coverFlow) {
        this.a = coverFlow;
    }

    @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.bq
    public void b(int i) {
        if (i == 0) {
            int currentItem = this.a.getCurrentItem();
            if (currentItem <= 1) {
                this.a.a((this.a.getAdapter().getCount() - 1) - 2, false);
                this.a.invalidate();
            } else if (currentItem >= this.a.getAdapter().getCount() - 2) {
                this.a.a(2, false);
                this.a.invalidate();
            }
        }
    }
}
