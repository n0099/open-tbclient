package com.baidu.tieba.gift.myGiftList;

import android.view.View;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements AbsListView.OnScrollListener {
    final /* synthetic */ m bof;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(m mVar) {
        this.bof = mVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        View view;
        View view2;
        if (i == 0) {
            view2 = this.bof.bod;
            view2.setVisibility(0);
            return;
        }
        view = this.bof.bod;
        view.setVisibility(8);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
