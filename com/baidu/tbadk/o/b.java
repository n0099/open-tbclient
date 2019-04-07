package com.baidu.tbadk.o;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private a cqd;
    private boolean cqe;
    private boolean cqf;

    public void aoW() {
        if (!this.cqe && m.apg().aph()) {
            this.cqe = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.cqd == null) {
                    this.cqd = new a();
                }
                this.cqd.start();
            }
        }
    }

    public void aoX() {
        if (Build.VERSION.SDK_INT >= 16 && this.cqd != null) {
            this.cqd.stop();
        }
    }

    public void aoY() {
        o oVar;
        if (!this.cqf && this.cqd != null && this.cqd.getFps() >= 0 && (oVar = (o) m.apg().jZ(this.mSubType)) != null) {
            oVar.a(this);
            this.cqf = true;
        }
    }

    public int getFps() {
        if (this.cqd != null) {
            return this.cqd.getFps();
        }
        return -1;
    }
}
