package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnTouchListener {
    final /* synthetic */ AbsMsglistView aWs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(AbsMsglistView absMsglistView) {
        this.aWs = absMsglistView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.aWs.sendmsgCloseSoftkey();
        this.aWs.sendmsgCloseMore();
        this.aWs.sendmsgCloseExpression();
        this.aWs.MainOnTouch();
        return false;
    }
}
