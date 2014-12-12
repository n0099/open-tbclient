package com.baidu.tbadk.widget;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Handler.Callback {
    final /* synthetic */ a aik;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aik = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        boolean z;
        switch (message.what) {
            case 0:
                this.aik.zF();
                break;
            case 1:
                z = this.aik.aij;
                if (z) {
                    this.aik.zF();
                    break;
                }
                break;
            case 2:
                this.aik.invalidate();
                this.aik.aii = System.currentTimeMillis();
                this.aik.mHandler.sendEmptyMessage(0);
                break;
        }
        return false;
    }
}
