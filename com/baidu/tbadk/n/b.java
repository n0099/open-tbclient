package com.baidu.tbadk.n;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private a dyZ;
    private boolean dza;
    private boolean dzb;

    public void aOq() {
        if (!this.dza && m.aOA().aOB()) {
            this.dza = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.dyZ == null) {
                    this.dyZ = new a();
                }
                this.dyZ.start();
            }
        }
    }

    public void aOr() {
        if (Build.VERSION.SDK_INT >= 16 && this.dyZ != null) {
            this.dyZ.stop();
        }
    }

    public void aOs() {
        o oVar;
        if (!this.dzb && this.dyZ != null && this.dyZ.getFps() >= 0 && (oVar = (o) m.aOA().mw(this.mSubType)) != null) {
            oVar.a(this);
            this.dzb = true;
        }
    }

    public int getFps() {
        if (this.dyZ != null) {
            return this.dyZ.getFps();
        }
        return -1;
    }
}
