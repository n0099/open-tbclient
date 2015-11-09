package com.baidu.tieba.im.chat;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements AbsListView.OnScrollListener {
    final /* synthetic */ AbsMsglistView brw;
    private final /* synthetic */ MsglistActivity brx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(AbsMsglistView absMsglistView, MsglistActivity msglistActivity) {
        this.brw = absMsglistView;
        this.brx = msglistActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.adp.lib.util.k.c(this.brx.getActivity(), this.brx.getActivity().getCurrentFocus());
        if (this.brw.mTool != null) {
            this.brw.mTool.zc();
        }
    }
}
