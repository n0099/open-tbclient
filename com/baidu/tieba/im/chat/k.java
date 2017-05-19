package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ AbsMsglistView cIW;
    private final /* synthetic */ MsglistActivity cIX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AbsMsglistView absMsglistView, MsglistActivity msglistActivity) {
        this.cIW = absMsglistView;
        this.cIX = msglistActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.adp.lib.util.k.b(this.cIX.getActivity(), this.cIX.getActivity().getCurrentFocus());
        if (this.cIW.mTool != null) {
            this.cIW.mTool.AN();
        }
        this.cIW.MainOnTouch();
        return false;
    }
}
