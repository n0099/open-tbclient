package com.baidu.tbadk.n;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private a eUs;
    private boolean eUt;
    private boolean eUu;

    public void bvi() {
        if (!this.eUt && m.bvs().bvt()) {
            this.eUt = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.eUs == null) {
                    this.eUs = new a();
                }
                this.eUs.start();
            }
        }
    }

    public void bvj() {
        if (Build.VERSION.SDK_INT >= 16 && this.eUs != null) {
            this.eUs.stop();
        }
    }

    public void bvk() {
        o oVar;
        if (!this.eUu && this.eUs != null && this.eUs.getFps() >= 0 && (oVar = (o) m.bvs().qT(this.mSubType)) != null) {
            oVar.a(this);
            this.eUu = true;
        }
    }

    public int getFps() {
        if (this.eUs != null) {
            return this.eUs.getFps();
        }
        return -1;
    }
}
