package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ AbsMsglistView cWq;
    private final /* synthetic */ MsglistActivity cWr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AbsMsglistView absMsglistView, MsglistActivity msglistActivity) {
        this.cWq = absMsglistView;
        this.cWr = msglistActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.adp.lib.util.k.b(this.cWr.getActivity(), this.cWr.getActivity().getCurrentFocus());
        if (this.cWq.mTool != null) {
            this.cWq.mTool.Bb();
        }
        this.cWq.MainOnTouch();
        return false;
    }
}
