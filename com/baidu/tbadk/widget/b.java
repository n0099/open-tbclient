package com.baidu.tbadk.widget;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Handler.Callback {
    final /* synthetic */ a aFj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aFj = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.aFj.HN();
                break;
            case 1:
                if (this.aFj.aFi) {
                    this.aFj.HN();
                    break;
                }
                break;
            case 2:
                this.aFj.invalidate();
                this.aFj.aFh = System.currentTimeMillis();
                this.aFj.mHandler.sendEmptyMessage(0);
                break;
        }
        return false;
    }
}
