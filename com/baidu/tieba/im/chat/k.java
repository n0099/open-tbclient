package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ AbsMsglistView bqH;
    private final /* synthetic */ MsglistActivity bqI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AbsMsglistView absMsglistView, MsglistActivity msglistActivity) {
        this.bqH = absMsglistView;
        this.bqI = msglistActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.adp.lib.util.k.c(this.bqI.getActivity(), this.bqI.getActivity().getCurrentFocus());
        if (this.bqH.mTool != null) {
            this.bqH.mTool.za();
        }
        this.bqH.MainOnTouch();
        return false;
    }
}
