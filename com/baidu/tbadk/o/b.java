package com.baidu.tbadk.o;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private a cqb;
    private boolean cqc;
    private boolean cqd;

    public void apa() {
        if (!this.cqc && m.apl().apm()) {
            this.cqc = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.cqb == null) {
                    this.cqb = new a();
                }
                this.cqb.start();
            }
        }
    }

    public void apb() {
        if (Build.VERSION.SDK_INT >= 16 && this.cqb != null) {
            this.cqb.stop();
        }
    }

    public void apc() {
        o oVar;
        if (!this.cqd && this.cqb != null && this.cqb.getFps() >= 0 && (oVar = (o) m.apl().ka(this.mSubType)) != null) {
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
