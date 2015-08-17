package com.baidu.tbadk.widget;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Handler.Callback {
    final /* synthetic */ a aAf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aAf = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.aAf.EO();
                break;
            case 1:
                if (this.aAf.aAe) {
                    this.aAf.EO();
                    break;
                }
                break;
            case 2:
                this.aAf.invalidate();
                this.aAf.aAd = System.currentTimeMillis();
                this.aAf.mHandler.sendEmptyMessage(0);
                break;
        }
        return false;
    }
}
