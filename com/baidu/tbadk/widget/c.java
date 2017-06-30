package com.baidu.tbadk.widget;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Handler.Callback {
    final /* synthetic */ b aLo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.aLo = bVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.aLo.Ho();
                break;
            case 1:
                if (this.aLo.aLn) {
                    this.aLo.Ho();
                    break;
                }
                break;
            case 2:
                this.aLo.invalidate();
                this.aLo.aLm = System.currentTimeMillis();
                this.aLo.mHandler.sendEmptyMessage(0);
                break;
        }
        return false;
    }
}
