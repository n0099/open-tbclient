package com.baidu.tieba.im.chat;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends Handler {
    final /* synthetic */ AbsMsglistView bYP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(AbsMsglistView absMsglistView) {
        this.bYP = absMsglistView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                handler = this.bYP.mHandler;
                handler.removeMessages(1);
                this.bYP.closeRecordCancel();
                this.bYP.closeRecordTooShort();
                return;
            default:
                return;
        }
    }
}
