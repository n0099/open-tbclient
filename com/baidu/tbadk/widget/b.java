package com.baidu.tbadk.widget;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Handler.Callback {
    final /* synthetic */ a aFz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aFz = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.aFz.GW();
                break;
            case 1:
                if (this.aFz.aFy) {
                    this.aFz.GW();
                    break;
                }
                break;
            case 2:
                this.aFz.invalidate();
                this.aFz.aFx = System.currentTimeMillis();
                this.aFz.mHandler.sendEmptyMessage(0);
                break;
        }
        return false;
    }
}
