package com.baidu.tbadk.widget;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Handler.Callback {
    final /* synthetic */ a asX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.asX = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        boolean z;
        switch (message.what) {
            case 0:
                this.asX.Ee();
                break;
            case 1:
                z = this.asX.asW;
                if (z) {
                    this.asX.Ee();
                    break;
                }
                break;
            case 2:
                this.asX.invalidate();
                this.asX.asV = System.currentTimeMillis();
                this.asX.mHandler.sendEmptyMessage(0);
                break;
        }
        return false;
    }
}
