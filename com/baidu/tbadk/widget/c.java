package com.baidu.tbadk.widget;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Handler.Callback {
    final /* synthetic */ b aJZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.aJZ = bVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.aJZ.GR();
                break;
            case 1:
                if (this.aJZ.aJY) {
                    this.aJZ.GR();
                    break;
                }
                break;
            case 2:
                this.aJZ.invalidate();
                this.aJZ.aJX = System.currentTimeMillis();
                this.aJZ.mHandler.sendEmptyMessage(0);
                break;
        }
        return false;
    }
}
