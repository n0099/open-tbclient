package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ AbsMsglistView cTO;
    private final /* synthetic */ MsglistActivity cTP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AbsMsglistView absMsglistView, MsglistActivity msglistActivity) {
        this.cTO = absMsglistView;
        this.cTP = msglistActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.adp.lib.util.k.b(this.cTP.getActivity(), this.cTP.getActivity().getCurrentFocus());
        if (this.cTO.mTool != null) {
            this.cTO.mTool.AV();
        }
        this.cTO.MainOnTouch();
        return false;
    }
}
