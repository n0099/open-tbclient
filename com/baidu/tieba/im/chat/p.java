package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnTouchListener {
    final /* synthetic */ AbsMsglistView aRm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(AbsMsglistView absMsglistView) {
        this.aRm = absMsglistView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.aRm.sendmsgCloseSoftkey();
        this.aRm.sendmsgCloseMore();
        this.aRm.sendmsgCloseExpression();
        this.aRm.MainOnTouch();
        return false;
    }
}
