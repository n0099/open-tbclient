package com.baidu.tbadk.n;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private a erK;
    private boolean erL;
    private boolean erM;

    public void bfz() {
        if (!this.erL && m.bfJ().bfK()) {
            this.erL = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.erK == null) {
                    this.erK = new a();
                }
                this.erK.start();
            }
        }
    }

    public void bfA() {
        if (Build.VERSION.SDK_INT >= 16 && this.erK != null) {
            this.erK.stop();
        }
    }

    public void bfB() {
        o oVar;
        if (!this.erM && this.erK != null && this.erK.getFps() >= 0 && (oVar = (o) m.bfJ().nE(this.mSubType)) != null) {
            oVar.a(this);
            this.erM = true;
        }
    }

    public int getFps() {
        if (this.erK != null) {
            return this.erK.getFps();
        }
        return -1;
    }
}
