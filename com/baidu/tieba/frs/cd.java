package com.baidu.tieba.frs;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cd implements Handler.Callback {
    final /* synthetic */ cc cff;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(cc ccVar) {
        this.cff = ccVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Handler handler;
        if ((message.what != 1 && message.what != 2) || !this.cff.abD()) {
            switch (message.what) {
                case 1:
                    this.cff.abC();
                    return true;
                case 2:
                    this.cff.abA();
                    return true;
                case 3:
                    this.cff.abB();
                    return true;
                default:
                    return false;
            }
        }
        handler = this.cff.mHandler;
        handler.sendEmptyMessageDelayed(message.what, 100L);
        return true;
    }
}
