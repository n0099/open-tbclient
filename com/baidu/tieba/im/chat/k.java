package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ AbsMsglistView cZw;
    private final /* synthetic */ MsglistActivity cZx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AbsMsglistView absMsglistView, MsglistActivity msglistActivity) {
        this.cZw = absMsglistView;
        this.cZx = msglistActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.adp.lib.util.k.b(this.cZx.getActivity(), this.cZx.getActivity().getCurrentFocus());
        if (this.cZw.mTool != null) {
            this.cZw.mTool.Bc();
        }
        this.cZw.MainOnTouch();
        return false;
    }
}
