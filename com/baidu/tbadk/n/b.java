package com.baidu.tbadk.n;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private a fue;
    private boolean fuf;
    private boolean fug;

    public void bBA() {
        if (!this.fuf && m.bBK().isSmallFlow()) {
            this.fuf = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.fue == null) {
                    this.fue = new a();
                }
                this.fue.start();
            }
        }
    }

    public void bBB() {
        if (Build.VERSION.SDK_INT >= 16 && this.fue != null) {
            this.fue.stop();
        }
    }

    public void bBC() {
        o oVar;
        if (!this.fug && this.fue != null && this.fue.getFps() >= 0 && (oVar = (o) m.bBK().sk(this.mSubType)) != null) {
            oVar.a(this);
            this.fug = true;
        }
    }

    public int getFps() {
        if (this.fue != null) {
            return this.fue.getFps();
        }
        return -1;
    }
}
