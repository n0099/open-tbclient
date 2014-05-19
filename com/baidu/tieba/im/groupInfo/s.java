package com.baidu.tieba.im.groupInfo;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends Handler {
    int a = 0;
    final /* synthetic */ r b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.b = rVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        super.handleMessage(message);
        if (message.what == 0) {
            if (this.a != 0) {
                if (this.a >= 3) {
                    this.b.A();
                    handler = this.b.ah;
                    handler.removeMessages(0);
                    return;
                }
            } else {
                this.b.z();
                this.b.y();
            }
            this.a++;
            handler2 = this.b.ah;
            handler2.sendEmptyMessageDelayed(0, 1000L);
        }
    }
}
