package com.baidu.tieba.im.groupInfo;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends Handler {
    final /* synthetic */ s bbt;
    int count = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.bbt = sVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        super.handleMessage(message);
        if (message.what == 0) {
            if (this.count != 0) {
                if (this.count >= 3) {
                    this.bbt.OF();
                    handler = this.bbt.bbr;
                    handler.removeMessages(0);
                    return;
                }
            } else {
                this.bbt.OE();
                this.bbt.OD();
            }
            this.count++;
            handler2 = this.bbt.bbr;
            handler2.sendEmptyMessageDelayed(0, 1000L);
        }
    }
}
