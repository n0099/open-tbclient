package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnTouchListener {
    final /* synthetic */ AbsMsglistView aZp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(AbsMsglistView absMsglistView) {
        this.aZp = absMsglistView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.aZp.sendmsgCloseSoftkey();
        this.aZp.sendmsgCloseMore();
        this.aZp.sendmsgCloseExpression();
        this.aZp.MainOnTouch();
        return false;
    }
}
