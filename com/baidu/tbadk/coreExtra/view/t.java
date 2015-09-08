package com.baidu.tbadk.coreExtra.view;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
/* loaded from: classes.dex */
class t extends Handler {
    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                LiveBroadcastCard.c.zp().sendTimeUpdateMessage();
                removeMessages(1);
                sendEmptyMessageDelayed(1, 1000L);
                return;
            default:
                return;
        }
    }
}
