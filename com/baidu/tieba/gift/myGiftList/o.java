package com.baidu.tieba.gift.myGiftList;

import android.view.View;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements AbsListView.OnScrollListener {
    final /* synthetic */ l bxd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar) {
        this.bxd = lVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        View view;
        View view2;
        if (i == 0) {
            view2 = this.bxd.bxc;
            view2.setVisibility(0);
            return;
        }
        view = this.bxd.bxc;
        view.setVisibility(8);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
