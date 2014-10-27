package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnTouchListener {
    final /* synthetic */ AbsMsglistView aNB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(AbsMsglistView absMsglistView) {
        this.aNB = absMsglistView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.aNB.mEdtMsgSendText.setCursorVisible(true);
            this.aNB.sendmsgCloseMore();
        } else if (motionEvent.getAction() == 0) {
            this.aNB.listGo2New();
            if (this.aNB.mFaceView.getVisibility() == 0) {
                this.aNB.sendmsgCloseExpression();
                this.aNB.sendmsgShowSoftkey();
                this.aNB.setEditTextSelectLast();
                return true;
            }
        }
        return false;
    }
}
