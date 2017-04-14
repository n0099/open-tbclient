package com.baidu.tieba.im.chat;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements AbsListView.OnScrollListener {
    final /* synthetic */ AbsMsglistView cMC;
    private final /* synthetic */ MsglistActivity cMD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(AbsMsglistView absMsglistView, MsglistActivity msglistActivity) {
        this.cMC = absMsglistView;
        this.cMD = msglistActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.adp.lib.util.k.b(this.cMD.getActivity(), this.cMD.getActivity().getCurrentFocus());
        if (this.cMC.mTool != null) {
            this.cMC.mTool.BC();
        }
    }
}
