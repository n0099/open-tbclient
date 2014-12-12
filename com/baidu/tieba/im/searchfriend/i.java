package com.baidu.tieba.im.searchfriend;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class i implements AbsListView.OnScrollListener {
    final /* synthetic */ SearchFriendActivity bmC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(SearchFriendActivity searchFriendActivity) {
        this.bmC = searchFriendActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        View view;
        if (i == 1) {
            this.bmC.HidenSoftKeyPad((InputMethodManager) this.bmC.getSystemService("input_method"), this.bmC.getActivity().getWindow().getDecorView());
            view = this.bmC.bmw;
            view.clearFocus();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
