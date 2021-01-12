package com.baidu.tbadk.n;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private a fGP;
    private boolean fGQ;
    private boolean fGR;

    public void bDG() {
        if (!this.fGQ && k.bDO().isSmallFlow()) {
            this.fGQ = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.fGP == null) {
                    this.fGP = new a();
                }
                this.fGP.start();
            }
        }
    }

    public void bDH() {
        if (Build.VERSION.SDK_INT >= 16 && this.fGP != null) {
            this.fGP.stop();
        }
    }

    public void bDI() {
        m mVar;
        if (!this.fGR && this.fGP != null && this.fGP.getFps() >= 0 && (mVar = (m) k.bDO().rq(this.mSubType)) != null) {
            mVar.a(this);
            this.fGR = true;
        }
    }

    public int getFps() {
        if (this.fGP != null) {
            return this.fGP.getFps();
        }
        return -1;
    }
}
