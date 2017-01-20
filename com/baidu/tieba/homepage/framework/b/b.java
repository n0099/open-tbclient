package com.baidu.tieba.homepage.framework.b;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Handler.Callback {
    final /* synthetic */ a cvV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cvV = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Handler handler;
        if ((message.what != 1 && message.what != 2) || !this.cvV.VL()) {
            switch (message.what) {
                case 1:
                    this.cvV.VH();
                    return true;
                case 2:
                    this.cvV.VF();
                    return true;
                case 3:
                    this.cvV.VG();
                    return true;
                default:
                    return false;
            }
        }
        handler = this.cvV.mHandler;
        handler.sendEmptyMessageDelayed(message.what, 100L);
        return true;
    }
}
