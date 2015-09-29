package com.baidu.tbadk.coreExtra.messageCenter;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class b extends Handler {
    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 0) {
            a.wK().b(a.wK().xg());
        }
    }
}
