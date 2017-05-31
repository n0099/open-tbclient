package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ AbsMsglistView cOu;
    private final /* synthetic */ MsglistActivity cOv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AbsMsglistView absMsglistView, MsglistActivity msglistActivity) {
        this.cOu = absMsglistView;
        this.cOv = msglistActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.adp.lib.util.k.b(this.cOv.getActivity(), this.cOv.getActivity().getCurrentFocus());
        if (this.cOu.mTool != null) {
            this.cOu.mTool.AG();
        }
        this.cOu.MainOnTouch();
        return false;
    }
}
