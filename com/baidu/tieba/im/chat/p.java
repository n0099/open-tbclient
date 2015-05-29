package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnTouchListener {
    final /* synthetic */ AbsMsglistView aZo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(AbsMsglistView absMsglistView) {
        this.aZo = absMsglistView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.aZo.sendmsgCloseSoftkey();
        this.aZo.sendmsgCloseMore();
        this.aZo.sendmsgCloseExpression();
        this.aZo.MainOnTouch();
        return false;
    }
}
