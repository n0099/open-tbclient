package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ AbsMsglistView cEI;
    private final /* synthetic */ MsglistActivity cEJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AbsMsglistView absMsglistView, MsglistActivity msglistActivity) {
        this.cEI = absMsglistView;
        this.cEJ = msglistActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.adp.lib.util.k.b(this.cEJ.getActivity(), this.cEJ.getActivity().getCurrentFocus());
        if (this.cEI.mTool != null) {
            this.cEI.mTool.AP();
        }
        this.cEI.MainOnTouch();
        return false;
    }
}
