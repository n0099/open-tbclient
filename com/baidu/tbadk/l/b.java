package com.baidu.tbadk.l;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private boolean aTA;
    private boolean aTB;
    private a aTz;

    public void Kv() {
        if (!this.aTA && m.KF().KG()) {
            this.aTA = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.aTz == null) {
                    this.aTz = new a();
                }
                this.aTz.start();
            }
        }
    }

    public void Kw() {
        if (Build.VERSION.SDK_INT >= 16 && this.aTz != null) {
            this.aTz.stop();
        }
    }

    public void Kx() {
        o oVar;
        if (!this.aTB && this.aTz != null && this.aTz.getFps() >= 0 && (oVar = (o) m.KF().fp(this.mSubType)) != null) {
            oVar.a(this);
            this.aTB = true;
        }
    }

    public int getFps() {
        if (this.aTz != null) {
            return this.aTz.getFps();
        }
        return -1;
    }
}
