package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ AbsMsglistView bGC;
    private final /* synthetic */ MsglistActivity bGD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AbsMsglistView absMsglistView, MsglistActivity msglistActivity) {
        this.bGC = absMsglistView;
        this.bGD = msglistActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.adp.lib.util.k.c(this.bGD.getActivity(), this.bGD.getActivity().getCurrentFocus());
        if (this.bGC.mTool != null) {
            this.bGC.mTool.zY();
        }
        this.bGC.MainOnTouch();
        return false;
    }
}
