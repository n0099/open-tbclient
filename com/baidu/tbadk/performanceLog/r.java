package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class r extends u {
    public int afX;
    public long agf;
    public long agg;
    public long agh;
    public int agi;
    private t agj = null;
    private final Handler agk = new s(this, Looper.getMainLooper());
    public long kf;
    public long vx;

    public void yX() {
        this.agk.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yY() {
        x xVar = (x) ac.zh().dT(this.mSubType);
        if (xVar != null) {
            xVar.c(this);
        }
    }
}
