package com.baidu.tbadk.p;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private a cKW;
    private boolean cKX;
    private boolean cKY;

    public void awB() {
        if (!this.cKX && m.awL().awM()) {
            this.cKX = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.cKW == null) {
                    this.cKW = new a();
                }
                this.cKW.start();
            }
        }
    }

    public void awC() {
        if (Build.VERSION.SDK_INT >= 16 && this.cKW != null) {
            this.cKW.stop();
        }
    }

    public void awD() {
        o oVar;
        if (!this.cKY && this.cKW != null && this.cKW.getFps() >= 0 && (oVar = (o) m.awL().kh(this.mSubType)) != null) {
            oVar.a(this);
            this.cKY = true;
        }
    }

    public int getFps() {
        if (this.cKW != null) {
            return this.cKW.getFps();
        }
        return -1;
    }
}
