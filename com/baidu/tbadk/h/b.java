package com.baidu.tbadk.h;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a aAB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aAB = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0 && a.aAz != null) {
            a.aAz.setLength(message.arg1);
            a.aAz.setSize(message.arg2);
            if (a.aAz.getCallback() != null) {
                a.aAz.getCallback().e(a.aAz);
            }
        }
    }
}
