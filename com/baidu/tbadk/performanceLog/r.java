package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class r extends y {
    public long Gx;
    public int aoN;
    public long aoV;
    public long aoW;
    public long aoX;
    public int aoY;
    private t aoZ = null;
    private final Handler apa = new s(this, Looper.getMainLooper());
    public long vy;

    public void Cw() {
        this.apa.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cx() {
        ab abVar = (ab) ah.CK().ed(this.mSubType);
        if (abVar != null) {
            abVar.c(this);
        }
    }
}
