package com.baidu.tieba.im.groupInfo;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends Handler {
    final /* synthetic */ t bbH;
    int count = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.bbH = tVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        super.handleMessage(message);
        if (message.what == 0) {
            if (this.count != 0) {
                if (this.count >= 3) {
                    this.bbH.OI();
                    handler = this.bbH.bbF;
                    handler.removeMessages(0);
                    return;
                }
            } else {
                this.bbH.OH();
                this.bbH.OG();
            }
            this.count++;
            handler2 = this.bbH.bbF;
            handler2.sendEmptyMessageDelayed(0, 1000L);
        }
    }
}
