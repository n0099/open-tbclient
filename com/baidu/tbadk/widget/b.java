package com.baidu.tbadk.widget;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Handler.Callback {
    final /* synthetic */ a aKb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aKb = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.aKb.HM();
                break;
            case 1:
                if (this.aKb.aKa) {
                    this.aKb.HM();
                    break;
                }
                break;
            case 2:
                this.aKb.invalidate();
                this.aKb.aJZ = System.currentTimeMillis();
                this.aKb.mHandler.sendEmptyMessage(0);
                break;
        }
        return false;
    }
}
