package com.baidu.tbadk.widget;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Handler.Callback {
    final /* synthetic */ a aJL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aJL = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.aJL.Hn();
                break;
            case 1:
                if (this.aJL.aJK) {
                    this.aJL.Hn();
                    break;
                }
                break;
            case 2:
                this.aJL.invalidate();
                this.aJL.aJJ = System.currentTimeMillis();
                this.aJL.mHandler.sendEmptyMessage(0);
                break;
        }
        return false;
    }
}
