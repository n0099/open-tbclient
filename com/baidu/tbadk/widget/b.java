package com.baidu.tbadk.widget;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Handler.Callback {
    final /* synthetic */ a aDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aDT = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.aDT.GL();
                break;
            case 1:
                if (this.aDT.aDS) {
                    this.aDT.GL();
                    break;
                }
                break;
            case 2:
                this.aDT.invalidate();
                this.aDT.aDR = System.currentTimeMillis();
                this.aDT.mHandler.sendEmptyMessage(0);
                break;
        }
        return false;
    }
}
