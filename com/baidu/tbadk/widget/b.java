package com.baidu.tbadk.widget;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Handler.Callback {
    final /* synthetic */ a aBt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aBt = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.aBt.FY();
                break;
            case 1:
                if (this.aBt.aBs) {
                    this.aBt.FY();
                    break;
                }
                break;
            case 2:
                this.aBt.invalidate();
                this.aBt.aBr = System.currentTimeMillis();
                this.aBt.mHandler.sendEmptyMessage(0);
                break;
        }
        return false;
    }
}
