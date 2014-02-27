package com.baidu.tieba.im.chat;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b extends Handler {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Handler handler;
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                handler = this.a.R;
                handler.removeMessages(1);
                this.a.m();
                this.a.k();
                return;
            default:
                return;
        }
    }
}
