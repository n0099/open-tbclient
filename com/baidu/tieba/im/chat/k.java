package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ AbsMsglistView cLR;
    private final /* synthetic */ MsglistActivity cLS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AbsMsglistView absMsglistView, MsglistActivity msglistActivity) {
        this.cLR = absMsglistView;
        this.cLS = msglistActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.adp.lib.util.k.b(this.cLS.getActivity(), this.cLS.getActivity().getCurrentFocus());
        if (this.cLR.mTool != null) {
            this.cLR.mTool.AK();
        }
        this.cLR.MainOnTouch();
        return false;
    }
}
