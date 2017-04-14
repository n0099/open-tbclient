package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ AbsMsglistView cMC;
    private final /* synthetic */ MsglistActivity cMD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AbsMsglistView absMsglistView, MsglistActivity msglistActivity) {
        this.cMC = absMsglistView;
        this.cMD = msglistActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.adp.lib.util.k.b(this.cMD.getActivity(), this.cMD.getActivity().getCurrentFocus());
        if (this.cMC.mTool != null) {
            this.cMC.mTool.BC();
        }
        this.cMC.MainOnTouch();
        return false;
    }
}
