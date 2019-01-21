package com.baidu.tbadk.l;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private a bgp;
    private boolean bgq;
    private boolean bgr;

    public void Pt() {
        if (!this.bgq && m.PD().PE()) {
            this.bgq = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.bgp == null) {
                    this.bgp = new a();
                }
                this.bgp.start();
            }
        }
    }

    public void Pu() {
        if (Build.VERSION.SDK_INT >= 16 && this.bgp != null) {
            this.bgp.stop();
        }
    }

    public void Pv() {
        o oVar;
        if (!this.bgr && this.bgp != null && this.bgp.getFps() >= 0 && (oVar = (o) m.PD().gm(this.mSubType)) != null) {
            oVar.a(this);
            this.bgr = true;
        }
    }

    public int getFps() {
        if (this.bgp != null) {
            return this.bgp.getFps();
        }
        return -1;
    }
}
