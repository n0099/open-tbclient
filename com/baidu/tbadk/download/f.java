package com.baidu.tbadk.download;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends Handler {
    final /* synthetic */ e aug;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(e eVar, Looper looper) {
        super(looper);
        this.aug = eVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0 && e.aud != null) {
            e.aud.setLength(message.arg1);
            e.aud.setSize(message.arg2);
            e.aud.setStatus(1);
            if (e.aud.getCallback() != null) {
                e.aud.getCallback().b(e.aud);
            }
        }
    }
}
