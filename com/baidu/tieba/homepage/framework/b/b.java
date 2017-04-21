package com.baidu.tieba.homepage.framework.b;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Handler.Callback {
    final /* synthetic */ a cyl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cyl = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Handler handler;
        if ((message.what != 1 && message.what != 2) || !this.cyl.Yi()) {
            switch (message.what) {
                case 1:
                    this.cyl.Ye();
                    return true;
                case 2:
                    this.cyl.Yc();
                    return true;
                case 3:
                    this.cyl.Yd();
                    return true;
                default:
                    return false;
            }
        }
        handler = this.cyl.mHandler;
        handler.sendEmptyMessageDelayed(message.what, 100L);
        return true;
    }
}
