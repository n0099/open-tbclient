package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ AbsMsglistView bnI;
    private final /* synthetic */ MsglistActivity bnJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AbsMsglistView absMsglistView, MsglistActivity msglistActivity) {
        this.bnI = absMsglistView;
        this.bnJ = msglistActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.adp.lib.util.k.c(this.bnJ.getActivity(), this.bnJ.getActivity().getCurrentFocus());
        if (this.bnI.mTool != null) {
            this.bnI.mTool.zr();
        }
        this.bnI.MainOnTouch();
        return false;
    }
}
