package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ AbsMsglistView aZo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AbsMsglistView absMsglistView) {
        this.aZo = absMsglistView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.aZo.mEdtMsgSendText.setCursorVisible(true);
            this.aZo.sendmsgCloseMore();
        } else if (motionEvent.getAction() == 0) {
            this.aZo.listGo2New();
            if (this.aZo.mFaceView.getVisibility() == 0) {
                this.aZo.sendmsgCloseExpression();
                this.aZo.sendmsgShowSoftkey();
                this.aZo.setEditTextSelectLast();
                return true;
            }
        }
        return false;
    }
}
