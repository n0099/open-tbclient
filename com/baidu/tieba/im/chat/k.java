package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ AbsMsglistView bnk;
    private final /* synthetic */ MsglistActivity bnl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AbsMsglistView absMsglistView, MsglistActivity msglistActivity) {
        this.bnk = absMsglistView;
        this.bnl = msglistActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.adp.lib.util.k.c(this.bnl.getActivity(), this.bnl.getActivity().getCurrentFocus());
        if (this.bnk.mTool != null) {
            this.bnk.mTool.zk();
        }
        this.bnk.MainOnTouch();
        return false;
    }
}
