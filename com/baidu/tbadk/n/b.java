package com.baidu.tbadk.n;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private a fBQ;
    private boolean fBR;
    private boolean fBS;

    public void bFd() {
        if (!this.fBR && l.bFl().isSmallFlow()) {
            this.fBR = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.fBQ == null) {
                    this.fBQ = new a();
                }
                this.fBQ.start();
            }
        }
    }

    public void bFe() {
        if (Build.VERSION.SDK_INT >= 16 && this.fBQ != null) {
            this.fBQ.stop();
        }
    }

    public void bFf() {
        n nVar;
        if (!this.fBS && this.fBQ != null && this.fBQ.getFps() >= 0 && (nVar = (n) l.bFl().sL(this.mSubType)) != null) {
            nVar.a(this);
            this.fBS = true;
        }
    }

    public int getFps() {
        if (this.fBQ != null) {
            return this.fBQ.getFps();
        }
        return -1;
    }
}
