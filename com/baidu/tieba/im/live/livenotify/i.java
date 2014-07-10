package com.baidu.tieba.im.live.livenotify;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class i extends Handler {
    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                h.a().b();
                removeMessages(1);
                sendEmptyMessageDelayed(1, 1000L);
                return;
            default:
                return;
        }
    }
}
