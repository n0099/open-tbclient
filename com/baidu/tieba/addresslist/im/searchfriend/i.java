package com.baidu.tieba.addresslist.im.searchfriend;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class i implements AbsListView.OnScrollListener {
    final /* synthetic */ SearchFriendActivity aAQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(SearchFriendActivity searchFriendActivity) {
        this.aAQ = searchFriendActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        View view;
        if (i == 1) {
            this.aAQ.HidenSoftKeyPad((InputMethodManager) this.aAQ.getSystemService("input_method"), this.aAQ.getActivity().getWindow().getDecorView());
            view = this.aAQ.aAJ;
            view.clearFocus();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
