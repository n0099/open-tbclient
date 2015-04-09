package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ AbsMsglistView aWI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AbsMsglistView absMsglistView) {
        this.aWI = absMsglistView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.aWI.mEdtMsgSendText.setCursorVisible(true);
            this.aWI.sendmsgCloseMore();
        } else if (motionEvent.getAction() == 0) {
            this.aWI.listGo2New();
            if (this.aWI.mFaceView.getVisibility() == 0) {
                this.aWI.sendmsgCloseExpression();
                this.aWI.sendmsgShowSoftkey();
                this.aWI.setEditTextSelectLast();
                return true;
            }
        }
        return false;
    }
}
