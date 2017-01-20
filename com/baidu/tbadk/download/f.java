package com.baidu.tbadk.download;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends Handler {
    final /* synthetic */ e asQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(e eVar, Looper looper) {
        super(looper);
        this.asQ = eVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0 && e.asN != null) {
            e.asN.setLength(message.arg1);
            e.asN.setSize(message.arg2);
            e.asN.setStatus(1);
            if (e.asN.getCallback() != null) {
                e.asN.getCallback().onFileUpdateProgress(e.asN);
            }
        }
    }
}
