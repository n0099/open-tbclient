package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class r extends u {
    public long agD;
    public long agE;
    public long agF;
    public int agG;
    private t agH = null;
    private final Handler agI = new s(this, Looper.getMainLooper());
    public int agv;
    public long ki;
    public long vD;

    public void zo() {
        this.agI.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zp() {
        x xVar = (x) ac.zy().dZ(this.mSubType);
        if (xVar != null) {
            xVar.c(this);
        }
    }
}
