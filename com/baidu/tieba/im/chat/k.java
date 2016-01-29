package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ AbsMsglistView bNS;
    private final /* synthetic */ MsglistActivity bNT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AbsMsglistView absMsglistView, MsglistActivity msglistActivity) {
        this.bNS = absMsglistView;
        this.bNT = msglistActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.adp.lib.util.k.c(this.bNT.getActivity(), this.bNT.getActivity().getCurrentFocus());
        if (this.bNS.mTool != null) {
            this.bNS.mTool.Ba();
        }
        this.bNS.MainOnTouch();
        return false;
    }
}
