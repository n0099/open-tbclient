package com.baidu.tbadk.widget;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Handler.Callback {
    final /* synthetic */ a aFp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aFp = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.aFp.Hx();
                break;
            case 1:
                if (this.aFp.aFo) {
                    this.aFp.Hx();
                    break;
                }
                break;
            case 2:
                this.aFp.invalidate();
                this.aFp.aFn = System.currentTimeMillis();
                this.aFp.mHandler.sendEmptyMessage(0);
                break;
        }
        return false;
    }
}
