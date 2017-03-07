package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ AbsMsglistView cOf;
    private final /* synthetic */ MsglistActivity cOg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AbsMsglistView absMsglistView, MsglistActivity msglistActivity) {
        this.cOf = absMsglistView;
        this.cOg = msglistActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.adp.lib.util.k.b(this.cOg.getActivity(), this.cOg.getActivity().getCurrentFocus());
        if (this.cOf.mTool != null) {
            this.cOf.mTool.Bd();
        }
        this.cOf.MainOnTouch();
        return false;
    }
}
