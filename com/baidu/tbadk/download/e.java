package com.baidu.tbadk.download;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends Handler {
    final /* synthetic */ d aot;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, Looper looper) {
        super(looper);
        this.aot = dVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0 && d.aoq != null) {
            d.aoq.setLength(message.arg1);
            d.aoq.setSize(message.arg2);
            d.aoq.setStatus(1);
            if (d.aoq.getCallback() != null) {
                d.aoq.getCallback().b(d.aoq);
            }
        }
    }
}
