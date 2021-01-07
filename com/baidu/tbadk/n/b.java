package com.baidu.tbadk.n;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private a fLw;
    private boolean fLx;
    private boolean fLy;

    public void bHy() {
        if (!this.fLx && k.bHG().isSmallFlow()) {
            this.fLx = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.fLw == null) {
                    this.fLw = new a();
                }
                this.fLw.start();
            }
        }
    }

    public void bHz() {
        if (Build.VERSION.SDK_INT >= 16 && this.fLw != null) {
            this.fLw.stop();
        }
    }

    public void bHA() {
        m mVar;
        if (!this.fLy && this.fLw != null && this.fLw.getFps() >= 0 && (mVar = (m) k.bHG().sW(this.mSubType)) != null) {
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
