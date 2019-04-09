package com.baidu.tbadk.o;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private a cqe;
    private boolean cqf;
    private boolean cqg;

    public void aoW() {
        if (!this.cqf && m.apg().aph()) {
            this.cqf = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.cqe == null) {
                    this.cqe = new a();
                }
                this.cqe.start();
            }
        }
    }

    public void aoX() {
        if (Build.VERSION.SDK_INT >= 16 && this.cqe != null) {
            this.cqe.stop();
        }
    }

    public void aoY() {
        o oVar;
        if (!this.cqg && this.cqe != null && this.cqe.getFps() >= 0 && (oVar = (o) m.apg().jZ(this.mSubType)) != null) {
            oVar.a(this);
            this.cqg = true;
        }
    }

    public int getFps() {
        if (this.cqe != null) {
            return this.cqe.getFps();
        }
        return -1;
    }
}
