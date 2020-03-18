package com.baidu.tbadk.n;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private a dDL;
    private boolean dDM;
    private boolean dDN;

    public void aRg() {
        if (!this.dDM && m.aRq().aRr()) {
            this.dDM = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.dDL == null) {
                    this.dDL = new a();
                }
                this.dDL.start();
            }
        }
    }

    public void aRh() {
        if (Build.VERSION.SDK_INT >= 16 && this.dDL != null) {
            this.dDL.stop();
        }
    }

    public void aRi() {
        o oVar;
        if (!this.dDN && this.dDL != null && this.dDL.getFps() >= 0 && (oVar = (o) m.aRq().mP(this.mSubType)) != null) {
            oVar.a(this);
            this.dDN = true;
        }
    }

    public int getFps() {
        if (this.dDL != null) {
            return this.dDL.getFps();
        }
        return -1;
    }
}
