package com.baidu.tieba.frs;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ci implements Handler.Callback {
    final /* synthetic */ ch bVG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(ch chVar) {
        this.bVG = chVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Handler handler;
        if ((message.what != 1 && message.what != 2) || !this.bVG.aad()) {
            switch (message.what) {
                case 1:
                    this.bVG.ZZ();
                    return true;
                case 2:
                    this.bVG.ZX();
                    return true;
                case 3:
                    this.bVG.ZY();
                    return true;
                default:
                    return false;
            }
        }
        handler = this.bVG.mHandler;
        handler.sendEmptyMessageDelayed(message.what, 100L);
        return true;
    }
}
