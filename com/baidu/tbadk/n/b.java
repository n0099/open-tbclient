package com.baidu.tbadk.n;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private a eRB;
    private boolean eRC;
    private boolean eRD;

    public void bue() {
        if (!this.eRC && m.buo().bup()) {
            this.eRC = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.eRB == null) {
                    this.eRB = new a();
                }
                this.eRB.start();
            }
        }
    }

    public void buf() {
        if (Build.VERSION.SDK_INT >= 16 && this.eRB != null) {
            this.eRB.stop();
        }
    }

    public void bug() {
        o oVar;
        if (!this.eRD && this.eRB != null && this.eRB.getFps() >= 0 && (oVar = (o) m.buo().qC(this.mSubType)) != null) {
            oVar.a(this);
            this.eRD = true;
        }
    }

    public int getFps() {
        if (this.eRB != null) {
            return this.eRB.getFps();
        }
        return -1;
    }
}
