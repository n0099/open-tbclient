package com.baidu.tbadk.n;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private a fgA;
    private boolean fgB;
    private boolean fgC;

    public void bxS() {
        if (!this.fgB && m.byc().byd()) {
            this.fgB = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.fgA == null) {
                    this.fgA = new a();
                }
                this.fgA.start();
            }
        }
    }

    public void bxT() {
        if (Build.VERSION.SDK_INT >= 16 && this.fgA != null) {
            this.fgA.stop();
        }
    }

    public void bxU() {
        o oVar;
        if (!this.fgC && this.fgA != null && this.fgA.getFps() >= 0 && (oVar = (o) m.byc().rr(this.mSubType)) != null) {
            oVar.a(this);
            this.fgC = true;
        }
    }

    public int getFps() {
        if (this.fgA != null) {
            return this.fgA.getFps();
        }
        return -1;
    }
}
