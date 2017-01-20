package com.baidu.tbadk.widget;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Handler.Callback {
    final /* synthetic */ a aEo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aEo = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.aEo.GO();
                break;
            case 1:
                if (this.aEo.aEn) {
                    this.aEo.GO();
                    break;
                }
                break;
            case 2:
                this.aEo.invalidate();
                this.aEo.aEm = System.currentTimeMillis();
                this.aEo.mHandler.sendEmptyMessage(0);
                break;
        }
        return false;
    }
}
