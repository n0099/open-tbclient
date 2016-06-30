package com.baidu.tieba.im.chat;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements AbsListView.OnScrollListener {
    final /* synthetic */ AbsMsglistView cDZ;
    private final /* synthetic */ MsglistActivity cEa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(AbsMsglistView absMsglistView, MsglistActivity msglistActivity) {
        this.cDZ = absMsglistView;
        this.cEa = msglistActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.adp.lib.util.k.a(this.cEa.getActivity(), this.cEa.getActivity().getCurrentFocus());
        if (this.cDZ.mTool != null) {
            this.cDZ.mTool.zD();
        }
    }
}
