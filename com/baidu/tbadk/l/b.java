package com.baidu.tbadk.l;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private a aWO;
    private boolean aWP;
    private boolean aWQ;

    public void LP() {
        if (!this.aWP && m.LZ().Ma()) {
            this.aWP = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.aWO == null) {
                    this.aWO = new a();
                }
                this.aWO.start();
            }
        }
    }

    public void LQ() {
        if (Build.VERSION.SDK_INT >= 16 && this.aWO != null) {
            this.aWO.stop();
        }
    }

    public void LR() {
        o oVar;
        if (!this.aWQ && this.aWO != null && this.aWO.getFps() >= 0 && (oVar = (o) m.LZ().fA(this.mSubType)) != null) {
            oVar.a(this);
            this.aWQ = true;
        }
    }

    public int getFps() {
        if (this.aWO != null) {
            return this.aWO.getFps();
        }
        return -1;
    }
}
