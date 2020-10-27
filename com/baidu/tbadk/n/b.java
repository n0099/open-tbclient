package com.baidu.tbadk.n;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private a foZ;
    private boolean fpa;
    private boolean fpb;

    public void bzL() {
        if (!this.fpa && m.bzV().bzW()) {
            this.fpa = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.foZ == null) {
                    this.foZ = new a();
                }
                this.foZ.start();
            }
        }
    }

    public void bzM() {
        if (Build.VERSION.SDK_INT >= 16 && this.foZ != null) {
            this.foZ.stop();
        }
    }

    public void bzN() {
        o oVar;
        if (!this.fpb && this.foZ != null && this.foZ.getFps() >= 0 && (oVar = (o) m.bzV().rC(this.mSubType)) != null) {
            oVar.a(this);
            this.fpb = true;
        }
    }

    public int getFps() {
        if (this.foZ != null) {
            return this.foZ.getFps();
        }
        return -1;
    }
}
