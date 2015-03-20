package com.baidu.tieba.addresslist.im.searchfriend;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class i implements AbsListView.OnScrollListener {
    final /* synthetic */ SearchFriendActivity ayX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(SearchFriendActivity searchFriendActivity) {
        this.ayX = searchFriendActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        View view;
        if (i == 1) {
            this.ayX.HidenSoftKeyPad((InputMethodManager) this.ayX.getSystemService("input_method"), this.ayX.getActivity().getWindow().getDecorView());
            view = this.ayX.ayQ;
            view.clearFocus();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
