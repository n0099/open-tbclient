package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ AbsMsglistView aRl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AbsMsglistView absMsglistView) {
        this.aRl = absMsglistView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.aRl.mEdtMsgSendText.setCursorVisible(true);
            this.aRl.sendmsgCloseMore();
        } else if (motionEvent.getAction() == 0) {
            this.aRl.listGo2New();
            if (this.aRl.mFaceView.getVisibility() == 0) {
                this.aRl.sendmsgCloseExpression();
                this.aRl.sendmsgShowSoftkey();
                this.aRl.setEditTextSelectLast();
                return true;
            }
        }
        return false;
    }
}
