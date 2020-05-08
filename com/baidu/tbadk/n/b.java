package com.baidu.tbadk.n;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private a edx;
    private boolean edy;
    private boolean edz;

    public void aZo() {
        if (!this.edy && m.aZy().aZz()) {
            this.edy = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.edx == null) {
                    this.edx = new a();
                }
                this.edx.start();
            }
        }
    }

    public void aZp() {
        if (Build.VERSION.SDK_INT >= 16 && this.edx != null) {
            this.edx.stop();
        }
    }

    public void aZq() {
        o oVar;
        if (!this.edz && this.edx != null && this.edx.getFps() >= 0 && (oVar = (o) m.aZy().na(this.mSubType)) != null) {
            oVar.a(this);
            this.edz = true;
        }
    }

    public int getFps() {
        if (this.edx != null) {
            return this.edx.getFps();
        }
        return -1;
    }
}
