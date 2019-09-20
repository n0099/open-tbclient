package com.baidu.tbadk.p;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private a cAE;
    private boolean cAF;
    private boolean cAG;

    public void avx() {
        if (!this.cAF && m.avH().avI()) {
            this.cAF = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.cAE == null) {
                    this.cAE = new a();
                }
                this.cAE.start();
            }
        }
    }

    public void avy() {
        if (Build.VERSION.SDK_INT >= 16 && this.cAE != null) {
            this.cAE.stop();
        }
    }

    public void avz() {
        o oVar;
        if (!this.cAG && this.cAE != null && this.cAE.getFps() >= 0 && (oVar = (o) m.avH().kX(this.mSubType)) != null) {
            oVar.a(this);
            this.cAG = true;
        }
    }

    public int getFps() {
        if (this.cAE != null) {
            return this.cAE.getFps();
        }
        return -1;
    }
}
