package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ AbsMsglistView bqS;
    private final /* synthetic */ MsglistActivity bqT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AbsMsglistView absMsglistView, MsglistActivity msglistActivity) {
        this.bqS = absMsglistView;
        this.bqT = msglistActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.adp.lib.util.k.c(this.bqT.getActivity(), this.bqT.getActivity().getCurrentFocus());
        if (this.bqS.mTool != null) {
            this.bqS.mTool.za();
        }
        this.bqS.MainOnTouch();
        return false;
    }
}
