package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ AbsMsglistView cDZ;
    private final /* synthetic */ MsglistActivity cEa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AbsMsglistView absMsglistView, MsglistActivity msglistActivity) {
        this.cDZ = absMsglistView;
        this.cEa = msglistActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.adp.lib.util.k.a(this.cEa.getActivity(), this.cEa.getActivity().getCurrentFocus());
        if (this.cDZ.mTool != null) {
            this.cDZ.mTool.zD();
        }
        this.cDZ.MainOnTouch();
        return false;
    }
}
