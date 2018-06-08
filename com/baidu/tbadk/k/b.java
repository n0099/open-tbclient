package com.baidu.tbadk.k;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private a aSC;
    private boolean aSD;
    private boolean aSE;

    public void Ki() {
        if (!this.aSD && m.Ks().Kt()) {
            this.aSD = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.aSC == null) {
                    this.aSC = new a();
                }
                this.aSC.start();
            }
        }
    }

    public void Kj() {
        if (Build.VERSION.SDK_INT >= 16 && this.aSC != null) {
            this.aSC.stop();
        }
    }

    public void Kk() {
        o oVar;
        if (!this.aSE && this.aSC != null && this.aSC.getFps() >= 0 && (oVar = (o) m.Ks().fn(this.mSubType)) != null) {
            oVar.a(this);
            this.aSE = true;
        }
    }

    public int getFps() {
        if (this.aSC != null) {
            return this.aSC.getFps();
        }
        return -1;
    }
}
