package com.baidu.tbadk.n;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private a dDk;
    private boolean dDl;
    private boolean dDm;

    public void aRb() {
        if (!this.dDl && m.aRl().aRm()) {
            this.dDl = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.dDk == null) {
                    this.dDk = new a();
                }
                this.dDk.start();
            }
        }
    }

    public void aRc() {
        if (Build.VERSION.SDK_INT >= 16 && this.dDk != null) {
            this.dDk.stop();
        }
    }

    public void aRd() {
        o oVar;
        if (!this.dDm && this.dDk != null && this.dDk.getFps() >= 0 && (oVar = (o) m.aRl().mN(this.mSubType)) != null) {
            oVar.a(this);
            this.dDm = true;
        }
    }

    public int getFps() {
        if (this.dDk != null) {
            return this.dDk.getFps();
        }
        return -1;
    }
}
