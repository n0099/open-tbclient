package com.baidu.tbadk.p;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private a cyl;
    private boolean cym;
    private boolean cyn;

    public void aua() {
        if (!this.cym && m.auk().aul()) {
            this.cym = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.cyl == null) {
                    this.cyl = new a();
                }
                this.cyl.start();
            }
        }
    }

    public void aub() {
        if (Build.VERSION.SDK_INT >= 16 && this.cyl != null) {
            this.cyl.stop();
        }
    }

    public void auc() {
        o oVar;
        if (!this.cyn && this.cyl != null && this.cyl.getFps() >= 0 && (oVar = (o) m.auk().kN(this.mSubType)) != null) {
            oVar.a(this);
            this.cyn = true;
        }
    }

    public int getFps() {
        if (this.cyl != null) {
            return this.cyl.getFps();
        }
        return -1;
    }
}
