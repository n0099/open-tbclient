package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class r extends y {
    public long Gp;
    public int aqa;
    public long aqi;
    public long aqj;
    public long aqk;
    public int aql;
    private t aqm = null;
    private final Handler aqn = new s(this, Looper.getMainLooper());
    public long uK;

    public void Do() {
        this.aqn.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dp() {
        ab abVar = (ab) ah.DC().en(this.mSubType);
        if (abVar != null) {
            abVar.c(this);
        }
    }
}
