package com.baidu.tbadk.widget;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Handler.Callback {
    final /* synthetic */ a aiK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aiK = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        boolean z;
        switch (message.what) {
            case 0:
                this.aiK.zT();
                break;
            case 1:
                z = this.aiK.aiJ;
                if (z) {
                    this.aiK.zT();
                    break;
                }
                break;
            case 2:
                this.aiK.invalidate();
                this.aiK.aiI = System.currentTimeMillis();
                this.aiK.mHandler.sendEmptyMessage(0);
                break;
        }
        return false;
    }
}
