package com.baidu.tbadk.l;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private a bfE;
    private boolean bfF;
    private boolean bfG;

    public void Pb() {
        if (!this.bfF && m.Pl().Pm()) {
            this.bfF = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.bfE == null) {
                    this.bfE = new a();
                }
                this.bfE.start();
            }
        }
    }

    public void Pc() {
        if (Build.VERSION.SDK_INT >= 16 && this.bfE != null) {
            this.bfE.stop();
        }
    }

    public void Pd() {
        o oVar;
        if (!this.bfG && this.bfE != null && this.bfE.getFps() >= 0 && (oVar = (o) m.Pl().gm(this.mSubType)) != null) {
            oVar.a(this);
            this.bfG = true;
        }
    }

    public int getFps() {
        if (this.bfE != null) {
            return this.bfE.getFps();
        }
        return -1;
    }
}
