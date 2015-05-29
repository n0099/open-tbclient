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

    public void Dn() {
        this.aqn.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Do() {
        ab abVar = (ab) ah.DB().en(this.mSubType);
        if (abVar != null) {
            abVar.c(this);
        }
    }
}
