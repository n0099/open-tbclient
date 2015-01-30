package com.baidu.tbadk.widget;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Handler.Callback {
    final /* synthetic */ a aiN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aiN = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        boolean z;
        switch (message.what) {
            case 0:
                this.aiN.zZ();
                break;
            case 1:
                z = this.aiN.aiM;
                if (z) {
                    this.aiN.zZ();
                    break;
                }
                break;
            case 2:
                this.aiN.invalidate();
                this.aiN.aiL = System.currentTimeMillis();
                this.aiN.mHandler.sendEmptyMessage(0);
                break;
        }
        return false;
    }
}
