package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class k extends n {
    public int YK;
    public long YQ;
    public long YR;
    public long YS;
    public int YT;
    private m YU = null;
    private final Handler YV = new l(this, Looper.getMainLooper());
    public long kd;
    public long tm;

    public void uF() {
        this.YV.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uG() {
        q qVar = (q) v.uP().dp(this.mSubType);
        if (qVar != null) {
            qVar.c(this);
        }
    }
}
