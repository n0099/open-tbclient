package com.baidu.tbadk.n;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private a fKB;
    private boolean fKC;
    private boolean fKD;

    public void bEc() {
        if (!this.fKC && k.bEk().isSmallFlow()) {
            this.fKC = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.fKB == null) {
                    this.fKB = new a();
                }
                this.fKB.start();
            }
        }
    }

    public void bEd() {
        if (Build.VERSION.SDK_INT >= 16 && this.fKB != null) {
            this.fKB.stop();
        }
    }

    public void bEe() {
        m mVar;
        if (!this.fKD && this.fKB != null && this.fKB.getFps() >= 0 && (mVar = (m) k.bEk().rx(this.mSubType)) != null) {
            mVar.a(this);
            this.fKD = true;
        }
    }

    public int getFps() {
        if (this.fKB != null) {
            return this.fKB.getFps();
        }
        return -1;
    }
}
