package com.baidu.tbadk.download;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends Handler {
    final /* synthetic */ d aqp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, Looper looper) {
        super(looper);
        this.aqp = dVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0 && d.aqm != null) {
            d.aqm.setLength(message.arg1);
            d.aqm.setSize(message.arg2);
            d.aqm.setStatus(1);
            if (d.aqm.getCallback() != null) {
                d.aqm.getCallback().d(d.aqm);
            }
        }
    }
}
