package com.baidu.tbadk.p;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private a cLN;
    private boolean cLO;
    private boolean cLP;

    public void awD() {
        if (!this.cLO && m.awN().awO()) {
            this.cLO = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.cLN == null) {
                    this.cLN = new a();
                }
                this.cLN.start();
            }
        }
    }

    public void awE() {
        if (Build.VERSION.SDK_INT >= 16 && this.cLN != null) {
            this.cLN.stop();
        }
    }

    public void awF() {
        o oVar;
        if (!this.cLP && this.cLN != null && this.cLN.getFps() >= 0 && (oVar = (o) m.awN().ki(this.mSubType)) != null) {
            oVar.a(this);
            this.cLP = true;
        }
    }

    public int getFps() {
        if (this.cLN != null) {
            return this.cLN.getFps();
        }
        return -1;
    }
}
