package com.baidu.tieba.im.chat;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements AbsListView.OnScrollListener {
    final /* synthetic */ AbsMsglistView cIW;
    private final /* synthetic */ MsglistActivity cIX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(AbsMsglistView absMsglistView, MsglistActivity msglistActivity) {
        this.cIW = absMsglistView;
        this.cIX = msglistActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.adp.lib.util.k.b(this.cIX.getActivity(), this.cIX.getActivity().getCurrentFocus());
        if (this.cIW.mTool != null) {
            this.cIW.mTool.AN();
        }
    }
}
