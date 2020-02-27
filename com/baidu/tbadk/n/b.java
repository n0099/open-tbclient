package com.baidu.tbadk.n;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private a dDj;
    private boolean dDk;
    private boolean dDl;

    public void aQZ() {
        if (!this.dDk && m.aRj().aRk()) {
            this.dDk = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.dDj == null) {
                    this.dDj = new a();
                }
                this.dDj.start();
            }
        }
    }

    public void aRa() {
        if (Build.VERSION.SDK_INT >= 16 && this.dDj != null) {
            this.dDj.stop();
        }
    }

    public void aRb() {
        o oVar;
        if (!this.dDl && this.dDj != null && this.dDj.getFps() >= 0 && (oVar = (o) m.aRj().mN(this.mSubType)) != null) {
            oVar.a(this);
            this.dDl = true;
        }
    }

    public int getFps() {
        if (this.dDj != null) {
            return this.dDj.getFps();
        }
        return -1;
    }
}
