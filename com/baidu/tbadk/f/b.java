package com.baidu.tbadk.f;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a azX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.azX = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0 && a.azV != null) {
            a.azV.setLength(message.arg1);
            a.azV.setSize(message.arg2);
            if (a.azV.getCallback() != null) {
                a.azV.getCallback().e(a.azV);
            }
        }
    }
}
