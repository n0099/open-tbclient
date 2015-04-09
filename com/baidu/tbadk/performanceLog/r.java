package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class r extends y {
    public long Gz;
    public int aoV;
    public long apd;
    public long ape;
    public long apf;
    public int apg;
    private t aph = null;
    private final Handler apj = new s(this, Looper.getMainLooper());
    public long vy;

    public void CC() {
        this.apj.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CD() {
        ab abVar = (ab) ah.CQ().ed(this.mSubType);
        if (abVar != null) {
            abVar.c(this);
        }
    }
}
