package com.baidu.tbadk.widget;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Handler.Callback {
    final /* synthetic */ a azq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.azq = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.azq.EC();
                break;
            case 1:
                if (this.azq.azp) {
                    this.azq.EC();
                    break;
                }
                break;
            case 2:
                this.azq.invalidate();
                this.azq.azo = System.currentTimeMillis();
                this.azq.mHandler.sendEmptyMessage(0);
                break;
        }
        return false;
    }
}
