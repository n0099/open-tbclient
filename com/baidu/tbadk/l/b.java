package com.baidu.tbadk.l;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private a bbo;
    private boolean bbp;
    private boolean bbq;

    public void NN() {
        if (!this.bbp && m.NX().NY()) {
            this.bbp = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.bbo == null) {
                    this.bbo = new a();
                }
                this.bbo.start();
            }
        }
    }

    public void NO() {
        if (Build.VERSION.SDK_INT >= 16 && this.bbo != null) {
            this.bbo.stop();
        }
    }

    public void NP() {
        o oVar;
        if (!this.bbq && this.bbo != null && this.bbo.getFps() >= 0 && (oVar = (o) m.NX().fJ(this.mSubType)) != null) {
            oVar.a(this);
            this.bbq = true;
        }
    }

    public int getFps() {
        if (this.bbo != null) {
            return this.bbo.getFps();
        }
        return -1;
    }
}
