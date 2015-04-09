package com.baidu.tbadk.widget;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Handler.Callback {
    final /* synthetic */ a aru;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aru = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        boolean z;
        switch (message.what) {
            case 0:
                this.aru.Du();
                break;
            case 1:
                z = this.aru.art;
                if (z) {
                    this.aru.Du();
                    break;
                }
                break;
            case 2:
                this.aru.invalidate();
                this.aru.ars = System.currentTimeMillis();
                this.aru.mHandler.sendEmptyMessage(0);
                break;
        }
        return false;
    }
}
