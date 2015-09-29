package com.baidu.tbadk.f;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a ayx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.ayx = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0 && a.ayv != null) {
            a.ayv.setLength(message.arg1);
            a.ayv.setSize(message.arg2);
            if (a.ayv.getCallback() != null) {
                a.ayv.getCallback().e(a.ayv);
            }
        }
    }
}
