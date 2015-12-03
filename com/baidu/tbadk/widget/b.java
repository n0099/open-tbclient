package com.baidu.tbadk.widget;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Handler.Callback {
    final /* synthetic */ a aBw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aBw = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.aBw.FF();
                break;
            case 1:
                if (this.aBw.aBv) {
                    this.aBw.FF();
                    break;
                }
                break;
            case 2:
                this.aBw.invalidate();
                this.aBw.aBu = System.currentTimeMillis();
                this.aBw.mHandler.sendEmptyMessage(0);
                break;
        }
        return false;
    }
}
