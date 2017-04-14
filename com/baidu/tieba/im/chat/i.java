package com.baidu.tieba.im.chat;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends Handler {
    final /* synthetic */ AbsMsglistView cMC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(AbsMsglistView absMsglistView) {
        this.cMC = absMsglistView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                handler = this.cMC.mHandler;
                handler.removeMessages(1);
                this.cMC.closeRecordCancel();
                this.cMC.closeRecordTooShort();
                return;
            default:
                return;
        }
    }
}
