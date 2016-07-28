package com.baidu.tbadk.widget;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Handler.Callback {
    final /* synthetic */ a aCJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aCJ = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.aCJ.Ge();
                break;
            case 1:
                if (this.aCJ.aCI) {
                    this.aCJ.Ge();
                    break;
                }
                break;
            case 2:
                this.aCJ.invalidate();
                this.aCJ.aCH = System.currentTimeMillis();
                this.aCJ.mHandler.sendEmptyMessage(0);
                break;
        }
        return false;
    }
}
