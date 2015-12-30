package com.baidu.tbadk.widget;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Handler.Callback {
    final /* synthetic */ a aDd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aDd = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.aDd.Ft();
                break;
            case 1:
                if (this.aDd.aDc) {
                    this.aDd.Ft();
                    break;
                }
                break;
            case 2:
                this.aDd.invalidate();
                this.aDd.aDb = System.currentTimeMillis();
                this.aDd.mHandler.sendEmptyMessage(0);
                break;
        }
        return false;
    }
}
