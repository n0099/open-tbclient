package com.baidu.tbadk.widget;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Handler.Callback {
    final /* synthetic */ a aAr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aAr = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.aAr.EN();
                break;
            case 1:
                if (this.aAr.aAq) {
                    this.aAr.EN();
                    break;
                }
                break;
            case 2:
                this.aAr.invalidate();
                this.aAr.aAp = System.currentTimeMillis();
                this.aAr.mHandler.sendEmptyMessage(0);
                break;
        }
        return false;
    }
}
