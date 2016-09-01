package com.baidu.tbadk.widget;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Handler.Callback {
    final /* synthetic */ a aFQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aFQ = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.aFQ.Hy();
                break;
            case 1:
                if (this.aFQ.aFP) {
                    this.aFQ.Hy();
                    break;
                }
                break;
            case 2:
                this.aFQ.invalidate();
                this.aFQ.aFO = System.currentTimeMillis();
                this.aFQ.mHandler.sendEmptyMessage(0);
                break;
        }
        return false;
    }
}
