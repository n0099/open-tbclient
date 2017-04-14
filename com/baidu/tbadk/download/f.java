package com.baidu.tbadk.download;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends Handler {
    final /* synthetic */ e ayB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(e eVar, Looper looper) {
        super(looper);
        this.ayB = eVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0 && e.ayy != null) {
            e.ayy.setLength(message.arg1);
            e.ayy.setSize(message.arg2);
            e.ayy.setStatus(1);
            if (e.ayy.getCallback() != null) {
                e.ayy.getCallback().onFileUpdateProgress(e.ayy);
            }
        }
    }
}
