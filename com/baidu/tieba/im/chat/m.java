package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnTouchListener {
    final /* synthetic */ AbsMsglistView aNP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(AbsMsglistView absMsglistView) {
        this.aNP = absMsglistView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.aNP.sendmsgCloseSoftkey();
        this.aNP.sendmsgCloseMore();
        this.aNP.sendmsgCloseExpression();
        this.aNP.MainOnTouch();
        return false;
    }
}
