package com.baidu.tbadk.n;

import android.os.Build;
/* loaded from: classes2.dex */
public class b extends g {
    private a eRx;
    private boolean eRy;
    private boolean eRz;

    public void bud() {
        if (!this.eRy && m.bun().buo()) {
            this.eRy = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.eRx == null) {
                    this.eRx = new a();
                }
                this.eRx.start();
            }
        }
    }

    public void bue() {
        if (Build.VERSION.SDK_INT >= 16 && this.eRx != null) {
            this.eRx.stop();
        }
    }

    public void buf() {
        o oVar;
        if (!this.eRz && this.eRx != null && this.eRx.getFps() >= 0 && (oVar = (o) m.bun().qC(this.mSubType)) != null) {
            oVar.a(this);
            this.eRz = true;
        }
    }

    public int getFps() {
        if (this.eRx != null) {
            return this.eRx.getFps();
        }
        return -1;
    }
}
