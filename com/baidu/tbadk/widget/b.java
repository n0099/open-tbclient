package com.baidu.tbadk.widget;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Handler.Callback {
    final /* synthetic */ a aBN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aBN = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.aBN.EY();
                break;
            case 1:
                if (this.aBN.aBM) {
                    this.aBN.EY();
                    break;
                }
                break;
            case 2:
                this.aBN.invalidate();
                this.aBN.aBL = System.currentTimeMillis();
                this.aBN.mHandler.sendEmptyMessage(0);
                break;
        }
        return false;
    }
}
