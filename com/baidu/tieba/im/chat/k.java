package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ AbsMsglistView cGO;
    private final /* synthetic */ MsglistActivity cGP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AbsMsglistView absMsglistView, MsglistActivity msglistActivity) {
        this.cGO = absMsglistView;
        this.cGP = msglistActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.adp.lib.util.k.b(this.cGP.getActivity(), this.cGP.getActivity().getCurrentFocus());
        if (this.cGO.mTool != null) {
            this.cGO.mTool.zD();
        }
        this.cGO.MainOnTouch();
        return false;
    }
}
