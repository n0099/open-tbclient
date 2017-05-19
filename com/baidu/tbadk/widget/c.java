package com.baidu.tbadk.widget;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Handler.Callback {
    final /* synthetic */ b aKm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.aKm = bVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.aKm.GX();
                break;
            case 1:
                if (this.aKm.aKl) {
                    this.aKm.GX();
                    break;
                }
                break;
            case 2:
                this.aKm.invalidate();
                this.aKm.aKk = System.currentTimeMillis();
                this.aKm.mHandler.sendEmptyMessage(0);
                break;
        }
        return false;
    }
}
