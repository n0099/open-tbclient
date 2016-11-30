package com.baidu.tbadk.widget;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Handler.Callback {
    final /* synthetic */ a aGf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aGf = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.aGf.HA();
                break;
            case 1:
                if (this.aGf.aGe) {
                    this.aGf.HA();
                    break;
                }
                break;
            case 2:
                this.aGf.invalidate();
                this.aGf.aGd = System.currentTimeMillis();
                this.aGf.mHandler.sendEmptyMessage(0);
                break;
        }
        return false;
    }
}
