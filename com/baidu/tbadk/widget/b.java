package com.baidu.tbadk.widget;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Handler.Callback {
    final /* synthetic */ a arm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.arm = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        boolean z;
        switch (message.what) {
            case 0:
                this.arm.Do();
                break;
            case 1:
                z = this.arm.arl;
                if (z) {
                    this.arm.Do();
                    break;
                }
                break;
            case 2:
                this.arm.invalidate();
                this.arm.ark = System.currentTimeMillis();
                this.arm.mHandler.sendEmptyMessage(0);
                break;
        }
        return false;
    }
}
