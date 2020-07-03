package com.baidu.tbadk.n;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private a eAC;
    private boolean eAD;
    private boolean eAE;

    public void bhF() {
        if (!this.eAD && m.bhP().bhQ()) {
            this.eAD = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.eAC == null) {
                    this.eAC = new a();
                }
                this.eAC.start();
            }
        }
    }

    public void bhG() {
        if (Build.VERSION.SDK_INT >= 16 && this.eAC != null) {
            this.eAC.stop();
        }
    }

    public void bhH() {
        o oVar;
        if (!this.eAE && this.eAC != null && this.eAC.getFps() >= 0 && (oVar = (o) m.bhP().nZ(this.mSubType)) != null) {
            oVar.a(this);
            this.eAE = true;
        }
    }

    public int getFps() {
        if (this.eAC != null) {
            return this.eAC.getFps();
        }
        return -1;
    }
}
