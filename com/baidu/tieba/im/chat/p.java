package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnTouchListener {
    final /* synthetic */ AbsMsglistView aQh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(AbsMsglistView absMsglistView) {
        this.aQh = absMsglistView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.aQh.sendmsgCloseSoftkey();
        this.aQh.sendmsgCloseMore();
        this.aQh.sendmsgCloseExpression();
        this.aQh.MainOnTouch();
        return false;
    }
}
