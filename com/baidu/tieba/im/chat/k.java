package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ AbsMsglistView aRm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AbsMsglistView absMsglistView) {
        this.aRm = absMsglistView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.aRm.mEdtMsgSendText.setCursorVisible(true);
            this.aRm.sendmsgCloseMore();
        } else if (motionEvent.getAction() == 0) {
            this.aRm.listGo2New();
            if (this.aRm.mFaceView.getVisibility() == 0) {
                this.aRm.sendmsgCloseExpression();
                this.aRm.sendmsgShowSoftkey();
                this.aRm.setEditTextSelectLast();
                return true;
            }
        }
        return false;
    }
}
