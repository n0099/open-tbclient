package com.baidu.tbadk.widget;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Handler.Callback {
    final /* synthetic */ a aKd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aKd = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.aKd.HM();
                break;
            case 1:
                if (this.aKd.aKc) {
                    this.aKd.HM();
                    break;
                }
                break;
            case 2:
                this.aKd.invalidate();
                this.aKd.aKb = System.currentTimeMillis();
                this.aKd.mHandler.sendEmptyMessage(0);
                break;
        }
        return false;
    }
}
