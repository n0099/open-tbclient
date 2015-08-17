package com.baidu.tbadk.download;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends Handler {
    final /* synthetic */ d aoi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, Looper looper) {
        super(looper);
        this.aoi = dVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0 && d.aof != null) {
            d.aof.setLength(message.arg1);
            d.aof.setSize(message.arg2);
            d.aof.setStatus(1);
            if (d.aof.getCallback() != null) {
                d.aof.getCallback().a(d.aof);
            }
        }
    }
}
