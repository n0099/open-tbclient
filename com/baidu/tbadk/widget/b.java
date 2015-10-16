package com.baidu.tbadk.widget;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Handler.Callback {
    final /* synthetic */ a aAC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aAC = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.aAC.EN();
                break;
            case 1:
                if (this.aAC.aAB) {
                    this.aAC.EN();
                    break;
                }
                break;
            case 2:
                this.aAC.invalidate();
                this.aAC.aAA = System.currentTimeMillis();
                this.aAC.mHandler.sendEmptyMessage(0);
                break;
        }
        return false;
    }
}
