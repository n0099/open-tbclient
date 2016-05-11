package com.baidu.tbadk.download;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends Handler {
    final /* synthetic */ e aoX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(e eVar, Looper looper) {
        super(looper);
        this.aoX = eVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0 && e.aoU != null) {
            e.aoU.setLength(message.arg1);
            e.aoU.setSize(message.arg2);
            e.aoU.setStatus(1);
            if (e.aoU.getCallback() != null) {
                e.aoU.getCallback().d(e.aoU);
            }
        }
    }
}
