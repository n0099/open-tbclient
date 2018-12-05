package com.baidu.tbadk.l;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private a bfB;
    private boolean bfC;
    private boolean bfD;

    public void Pa() {
        if (!this.bfC && m.Pk().Pl()) {
            this.bfC = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.bfB == null) {
                    this.bfB = new a();
                }
                this.bfB.start();
            }
        }
    }

    public void Pb() {
        if (Build.VERSION.SDK_INT >= 16 && this.bfB != null) {
            this.bfB.stop();
        }
    }

    public void Pc() {
        o oVar;
        if (!this.bfD && this.bfB != null && this.bfB.getFps() >= 0 && (oVar = (o) m.Pk().gl(this.mSubType)) != null) {
            oVar.a(this);
            this.bfD = true;
        }
    }

    public int getFps() {
        if (this.bfB != null) {
            return this.bfB.getFps();
        }
        return -1;
    }
}
