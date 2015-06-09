package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ AbsMsglistView aZp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AbsMsglistView absMsglistView) {
        this.aZp = absMsglistView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.aZp.mEdtMsgSendText.setCursorVisible(true);
            this.aZp.sendmsgCloseMore();
        } else if (motionEvent.getAction() == 0) {
            this.aZp.listGo2New();
            if (this.aZp.mFaceView.getVisibility() == 0) {
                this.aZp.sendmsgCloseExpression();
                this.aZp.sendmsgShowSoftkey();
                this.aZp.setEditTextSelectLast();
                return true;
            }
        }
        return false;
    }
}
