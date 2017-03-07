package com.baidu.tbadk.download;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends Handler {
    final /* synthetic */ e ayl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(e eVar, Looper looper) {
        super(looper);
        this.ayl = eVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0 && e.ayi != null) {
            e.ayi.setLength(message.arg1);
            e.ayi.setSize(message.arg2);
            e.ayi.setStatus(1);
            if (e.ayi.getCallback() != null) {
                e.ayi.getCallback().onFileUpdateProgress(e.ayi);
            }
        }
    }
}
