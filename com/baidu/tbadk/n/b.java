package com.baidu.tbadk.n;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private a fLw;
    private boolean fLx;
    private boolean fLy;

    public void bHx() {
        if (!this.fLx && k.bHF().isSmallFlow()) {
            this.fLx = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.fLw == null) {
                    this.fLw = new a();
                }
                this.fLw.start();
            }
        }
    }

    public void bHy() {
        if (Build.VERSION.SDK_INT >= 16 && this.fLw != null) {
            this.fLw.stop();
        }
    }

    public void bHz() {
        m mVar;
        if (!this.fLy && this.fLw != null && this.fLw.getFps() >= 0 && (mVar = (m) k.bHF().sW(this.mSubType)) != null) {
            mVar.a(this);
            this.fLy = true;
        }
    }

    public int getFps() {
        if (this.fLw != null) {
            return this.fLw.getFps();
        }
        return -1;
    }
}
