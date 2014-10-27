package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnTouchListener {
    final /* synthetic */ AbsMsglistView aNB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(AbsMsglistView absMsglistView) {
        this.aNB = absMsglistView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.aNB.sendmsgCloseSoftkey();
        this.aNB.sendmsgCloseMore();
        this.aNB.sendmsgCloseExpression();
        this.aNB.MainOnTouch();
        return false;
    }
}
