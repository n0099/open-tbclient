package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnTouchListener {
    final /* synthetic */ AbsMsglistView aNP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(AbsMsglistView absMsglistView) {
        this.aNP = absMsglistView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.aNP.mEdtMsgSendText.setCursorVisible(true);
            this.aNP.sendmsgCloseMore();
        } else if (motionEvent.getAction() == 0) {
            this.aNP.listGo2New();
            if (this.aNP.mFaceView.getVisibility() == 0) {
                this.aNP.sendmsgCloseExpression();
                this.aNP.sendmsgShowSoftkey();
                this.aNP.setEditTextSelectLast();
                return true;
            }
        }
        return false;
    }
}
