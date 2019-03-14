package com.baidu.tbadk.o;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private a cqb;
    private boolean cqc;
    private boolean cqd;

    public void aoZ() {
        if (!this.cqc && m.apk().apl()) {
            this.cqc = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.cqb == null) {
                    this.cqb = new a();
                }
                this.cqb.start();
            }
        }
    }

    public void apa() {
        if (Build.VERSION.SDK_INT >= 16 && this.cqb != null) {
            this.cqb.stop();
        }
    }

    public void apb() {
        o oVar;
        if (!this.cqd && this.cqb != null && this.cqb.getFps() >= 0 && (oVar = (o) m.apk().ka(this.mSubType)) != null) {
            oVar.a(this);
            this.cqd = true;
        }
    }

    public int getFps() {
        if (this.cqb != null) {
            return this.cqb.getFps();
        }
        return -1;
    }
}
