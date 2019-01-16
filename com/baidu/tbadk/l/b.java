package com.baidu.tbadk.l;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private a bgo;
    private boolean bgp;
    private boolean bgq;

    public void Pt() {
        if (!this.bgp && m.PD().PE()) {
            this.bgp = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.bgo == null) {
                    this.bgo = new a();
                }
                this.bgo.start();
            }
        }
    }

    public void Pu() {
        if (Build.VERSION.SDK_INT >= 16 && this.bgo != null) {
            this.bgo.stop();
        }
    }

    public void Pv() {
        o oVar;
        if (!this.bgq && this.bgo != null && this.bgo.getFps() >= 0 && (oVar = (o) m.PD().gm(this.mSubType)) != null) {
            oVar.a(this);
            this.bgq = true;
        }
    }

    public int getFps() {
        if (this.bgo != null) {
            return this.bgo.getFps();
        }
        return -1;
    }
}
