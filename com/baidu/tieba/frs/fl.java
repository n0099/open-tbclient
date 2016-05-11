package com.baidu.tieba.frs;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fl implements Handler.Callback {
    final /* synthetic */ fk bmR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fl(fk fkVar) {
        this.bmR = fkVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Handler handler;
        if ((message.what != 1 && message.what != 2) || !this.bmR.RQ()) {
            switch (message.what) {
                case 1:
                    this.bmR.RM();
                    return true;
                case 2:
                    this.bmR.RK();
                    return true;
                case 3:
                    this.bmR.RL();
                    return true;
                default:
                    return false;
            }
        }
        handler = this.bmR.mHandler;
        handler.sendEmptyMessageDelayed(message.what, 100L);
        return true;
    }
}
