package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ AbsMsglistView aWs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AbsMsglistView absMsglistView) {
        this.aWs = absMsglistView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.aWs.mEdtMsgSendText.setCursorVisible(true);
            this.aWs.sendmsgCloseMore();
        } else if (motionEvent.getAction() == 0) {
            this.aWs.listGo2New();
            if (this.aWs.mFaceView.getVisibility() == 0) {
                this.aWs.sendmsgCloseExpression();
                this.aWs.sendmsgShowSoftkey();
                this.aWs.setEditTextSelectLast();
                return true;
            }
        }
        return false;
    }
}
