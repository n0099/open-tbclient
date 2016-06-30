package com.baidu.tbadk.widget;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Handler.Callback {
    final /* synthetic */ a aBT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aBT = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.aBT.Gb();
                break;
            case 1:
                if (this.aBT.aBS) {
                    this.aBT.Gb();
                    break;
                }
                break;
            case 2:
                this.aBT.invalidate();
                this.aBT.aBR = System.currentTimeMillis();
                this.aBT.mHandler.sendEmptyMessage(0);
                break;
        }
        return false;
    }
}
