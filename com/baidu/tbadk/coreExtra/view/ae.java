package com.baidu.tbadk.coreExtra.view;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class ae extends Handler {
    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                ad.qb().qc();
                removeMessages(1);
                sendEmptyMessageDelayed(1, 1000L);
                return;
            default:
                return;
        }
    }
}
