package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ AbsMsglistView bYk;
    private final /* synthetic */ MsglistActivity bYl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AbsMsglistView absMsglistView, MsglistActivity msglistActivity) {
        this.bYk = absMsglistView;
        this.bYl = msglistActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.adp.lib.util.k.c(this.bYl.getActivity(), this.bYl.getActivity().getCurrentFocus());
        if (this.bYk.mTool != null) {
            this.bYk.mTool.BD();
        }
        this.bYk.MainOnTouch();
        return false;
    }
}
