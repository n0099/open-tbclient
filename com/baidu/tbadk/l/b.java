package com.baidu.tbadk.l;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private boolean aTA;
    private boolean aTB;
    private a aTz;

    public void Kz() {
        if (!this.aTA && m.KJ().KK()) {
            this.aTA = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.aTz == null) {
                    this.aTz = new a();
                }
                this.aTz.start();
            }
        }
    }

    public void KA() {
        if (Build.VERSION.SDK_INT >= 16 && this.aTz != null) {
            this.aTz.stop();
        }
    }

    public void KB() {
        o oVar;
        if (!this.aTB && this.aTz != null && this.aTz.getFps() >= 0 && (oVar = (o) m.KJ().fo(this.mSubType)) != null) {
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
