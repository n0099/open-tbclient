package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ AbsMsglistView brw;
    private final /* synthetic */ MsglistActivity brx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AbsMsglistView absMsglistView, MsglistActivity msglistActivity) {
        this.brw = absMsglistView;
        this.brx = msglistActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.adp.lib.util.k.c(this.brx.getActivity(), this.brx.getActivity().getCurrentFocus());
        if (this.brw.mTool != null) {
            this.brw.mTool.zc();
        }
        this.brw.MainOnTouch();
        return false;
    }
}
