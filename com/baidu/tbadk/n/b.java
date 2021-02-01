package com.baidu.tbadk.n;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private a fJb;
    private boolean fJc;
    private boolean fJd;

    public void bDY() {
        if (!this.fJc && k.bEg().isSmallFlow()) {
            this.fJc = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.fJb == null) {
                    this.fJb = new a();
                }
                this.fJb.start();
            }
        }
    }

    public void bDZ() {
        if (Build.VERSION.SDK_INT >= 16 && this.fJb != null) {
            this.fJb.stop();
        }
    }

    public void bEa() {
        m mVar;
        if (!this.fJd && this.fJb != null && this.fJb.getFps() >= 0 && (mVar = (m) k.bEg().rv(this.mSubType)) != null) {
            mVar.a(this);
            this.fJd = true;
        }
    }

    public int getFps() {
        if (this.fJb != null) {
            return this.fJb.getFps();
        }
        return -1;
    }
}
