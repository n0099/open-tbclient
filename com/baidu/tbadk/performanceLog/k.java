package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class k extends n {
    public int YG;
    public long YM;
    public long YN;
    public long YO;
    public int YP;
    private m YQ = null;
    private final Handler YR = new l(this, Looper.getMainLooper());
    public long kd;
    public long tm;

    public void uD() {
        this.YR.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uE() {
        q qVar = (q) v.uN().dp(this.mSubType);
        if (qVar != null) {
            qVar.c(this);
        }
    }
}
