package com.baidu.tieba.im.chat;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends Handler {
    final /* synthetic */ AbsMsglistView bqH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(AbsMsglistView absMsglistView) {
        this.bqH = absMsglistView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                handler = this.bqH.mHandler;
                handler.removeMessages(1);
                this.bqH.closeRecordCancel();
                this.bqH.closeRecordTooShort();
                return;
            default:
                return;
        }
    }
}
