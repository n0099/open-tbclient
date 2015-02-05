package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class r extends u {
    public long agA;
    public long agB;
    public long agC;
    public int agD;
    private t agE = null;
    private final Handler agF = new s(this, Looper.getMainLooper());
    public int ags;
    public long ki;
    public long vA;

    public void zi() {
        this.agF.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zj() {
        x xVar = (x) ac.zs().dZ(this.mSubType);
        if (xVar != null) {
            xVar.c(this);
        }
    }
}
