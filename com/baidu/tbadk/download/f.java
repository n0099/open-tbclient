package com.baidu.tbadk.download;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends Handler {
    final /* synthetic */ e atI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(e eVar, Looper looper) {
        super(looper);
        this.atI = eVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0 && e.atF != null) {
            e.atF.setLength(message.arg1);
            e.atF.setSize(message.arg2);
            e.atF.setStatus(1);
            if (e.atF.getCallback() != null) {
                e.atF.getCallback().b(e.atF);
            }
        }
    }
}
