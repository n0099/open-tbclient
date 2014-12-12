package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ AbsMsglistView aQh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AbsMsglistView absMsglistView) {
        this.aQh = absMsglistView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.aQh.mEdtMsgSendText.setCursorVisible(true);
            this.aQh.sendmsgCloseMore();
        } else if (motionEvent.getAction() == 0) {
            this.aQh.listGo2New();
            if (this.aQh.mFaceView.getVisibility() == 0) {
                this.aQh.sendmsgCloseExpression();
                this.aQh.sendmsgShowSoftkey();
                this.aQh.setEditTextSelectLast();
                return true;
            }
        }
        return false;
    }
}
