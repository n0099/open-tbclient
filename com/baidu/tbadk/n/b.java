package com.baidu.tbadk.n;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private a eds;
    private boolean edt;
    private boolean edu;

    public void aZq() {
        if (!this.edt && m.aZA().aZB()) {
            this.edt = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.eds == null) {
                    this.eds = new a();
                }
                this.eds.start();
            }
        }
    }

    public void aZr() {
        if (Build.VERSION.SDK_INT >= 16 && this.eds != null) {
            this.eds.stop();
        }
    }

    public void aZs() {
        o oVar;
        if (!this.edu && this.eds != null && this.eds.getFps() >= 0 && (oVar = (o) m.aZA().na(this.mSubType)) != null) {
            oVar.a(this);
            this.edu = true;
        }
    }

    public int getFps() {
        if (this.eds != null) {
            return this.eds.getFps();
        }
        return -1;
    }
}
