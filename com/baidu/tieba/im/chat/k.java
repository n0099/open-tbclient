package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ AbsMsglistView bKj;
    private final /* synthetic */ MsglistActivity bKk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AbsMsglistView absMsglistView, MsglistActivity msglistActivity) {
        this.bKj = absMsglistView;
        this.bKk = msglistActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.adp.lib.util.k.c(this.bKk.getActivity(), this.bKk.getActivity().getCurrentFocus());
        if (this.bKj.mTool != null) {
            this.bKj.mTool.zK();
        }
        this.bKj.MainOnTouch();
        return false;
    }
}
