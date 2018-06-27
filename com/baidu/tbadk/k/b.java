package com.baidu.tbadk.k;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private boolean aTA;
    private a aTy;
    private boolean aTz;

    public void KA() {
        if (!this.aTz && m.KK().KL()) {
            this.aTz = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.aTy == null) {
                    this.aTy = new a();
                }
                this.aTy.start();
            }
        }
    }

    public void KB() {
        if (Build.VERSION.SDK_INT >= 16 && this.aTy != null) {
            this.aTy.stop();
        }
    }

    public void KC() {
        o oVar;
        if (!this.aTA && this.aTy != null && this.aTy.getFps() >= 0 && (oVar = (o) m.KK().fo(this.mSubType)) != null) {
            oVar.a(this);
            this.aTA = true;
        }
    }

    public int getFps() {
        if (this.aTy != null) {
            return this.aTy.getFps();
        }
        return -1;
    }
}
