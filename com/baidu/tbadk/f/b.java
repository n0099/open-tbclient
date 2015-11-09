package com.baidu.tbadk.f;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a axx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.axx = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0 && a.axv != null) {
            a.axv.setLength(message.arg1);
            a.axv.setSize(message.arg2);
            if (a.axv.getCallback() != null) {
                a.axv.getCallback().e(a.axv);
            }
        }
    }
}
