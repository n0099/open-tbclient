package com.baidu.tbadk.download;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends Handler {
    final /* synthetic */ d asM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, Looper looper) {
        super(looper);
        this.asM = dVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0 && d.asJ != null) {
            d.asJ.setLength(message.arg1);
            d.asJ.setSize(message.arg2);
            d.asJ.setStatus(1);
            if (d.asJ.getCallback() != null) {
                d.asJ.getCallback().d(d.asJ);
            }
        }
    }
}
