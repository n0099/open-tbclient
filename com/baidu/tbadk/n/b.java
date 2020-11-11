package com.baidu.tbadk.n;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private a fuU;
    private boolean fuV;
    private boolean fuW;

    public void bCk() {
        if (!this.fuV && m.bCu().bCv()) {
            this.fuV = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.fuU == null) {
                    this.fuU = new a();
                }
                this.fuU.start();
            }
        }
    }

    public void bCl() {
        if (Build.VERSION.SDK_INT >= 16 && this.fuU != null) {
            this.fuU.stop();
        }
    }

    public void bCm() {
        o oVar;
        if (!this.fuW && this.fuU != null && this.fuU.getFps() >= 0 && (oVar = (o) m.bCu().rM(this.mSubType)) != null) {
            oVar.a(this);
            this.fuW = true;
        }
    }

    public int getFps() {
        if (this.fuU != null) {
            return this.fuU.getFps();
        }
        return -1;
    }
}
