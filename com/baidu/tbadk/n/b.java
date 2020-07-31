package com.baidu.tbadk.n;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private a eGR;
    private boolean eGS;
    private boolean eGT;

    public void blq() {
        if (!this.eGS && m.blA().blB()) {
            this.eGS = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.eGR == null) {
                    this.eGR = new a();
                }
                this.eGR.start();
            }
        }
    }

    public void blr() {
        if (Build.VERSION.SDK_INT >= 16 && this.eGR != null) {
            this.eGR.stop();
        }
    }

    public void bls() {
        o oVar;
        if (!this.eGT && this.eGR != null && this.eGR.getFps() >= 0 && (oVar = (o) m.blA().or(this.mSubType)) != null) {
            oVar.a(this);
            this.eGT = true;
        }
    }

    public int getFps() {
        if (this.eGR != null) {
            return this.eGR.getFps();
        }
        return -1;
    }
}
