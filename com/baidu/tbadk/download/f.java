package com.baidu.tbadk.download;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends Handler {
    final /* synthetic */ e azo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(e eVar, Looper looper) {
        super(looper);
        this.azo = eVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0 && e.azl != null) {
            e.azl.setLength(message.arg1);
            e.azl.setSize(message.arg2);
            e.azl.setStatus(1);
            if (e.azl.getCallback() != null) {
                e.azl.getCallback().onFileUpdateProgress(e.azl);
            }
        }
    }
}
