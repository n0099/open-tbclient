package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ AbsMsglistView bYP;
    private final /* synthetic */ MsglistActivity bYQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AbsMsglistView absMsglistView, MsglistActivity msglistActivity) {
        this.bYP = absMsglistView;
        this.bYQ = msglistActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.adp.lib.util.k.a(this.bYQ.getActivity(), this.bYQ.getActivity().getCurrentFocus());
        if (this.bYP.mTool != null) {
            this.bYP.mTool.zy();
        }
        this.bYP.MainOnTouch();
        return false;
    }
}
