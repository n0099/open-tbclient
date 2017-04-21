package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ AbsMsglistView cOT;
    private final /* synthetic */ MsglistActivity cOU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AbsMsglistView absMsglistView, MsglistActivity msglistActivity) {
        this.cOT = absMsglistView;
        this.cOU = msglistActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.adp.lib.util.k.b(this.cOU.getActivity(), this.cOU.getActivity().getCurrentFocus());
        if (this.cOT.mTool != null) {
            this.cOT.mTool.BC();
        }
        this.cOT.MainOnTouch();
        return false;
    }
}
