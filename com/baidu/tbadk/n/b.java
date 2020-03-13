package com.baidu.tbadk.n;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private a dDx;
    private boolean dDy;
    private boolean dDz;

    public void aRc() {
        if (!this.dDy && m.aRm().aRn()) {
            this.dDy = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.dDx == null) {
                    this.dDx = new a();
                }
                this.dDx.start();
            }
        }
    }

    public void aRd() {
        if (Build.VERSION.SDK_INT >= 16 && this.dDx != null) {
            this.dDx.stop();
        }
    }

    public void aRe() {
        o oVar;
        if (!this.dDz && this.dDx != null && this.dDx.getFps() >= 0 && (oVar = (o) m.aRm().mN(this.mSubType)) != null) {
            oVar.a(this);
            this.dDz = true;
        }
    }

    public int getFps() {
        if (this.dDx != null) {
            return this.dDx.getFps();
        }
        return -1;
    }
}
