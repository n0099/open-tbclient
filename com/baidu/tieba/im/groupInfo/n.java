package com.baidu.tieba.im.groupInfo;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends Handler {
    int a = 0;
    final /* synthetic */ m b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.b = mVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        super.handleMessage(message);
        if (message.what == 0) {
            if (this.a != 0) {
                if (this.a >= 3) {
                    this.b.C();
                    handler = this.b.ai;
                    handler.removeMessages(0);
                    return;
                }
            } else {
                this.b.B();
                this.b.A();
            }
            this.a++;
            handler2 = this.b.ai;
            handler2.sendEmptyMessageDelayed(0, 1000L);
        }
    }
}
