package com.baidu.tbadk.l;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private a bcb;
    private boolean bcc;
    private boolean bcd;

    public void NW() {
        if (!this.bcc && m.Og().Oh()) {
            this.bcc = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.bcb == null) {
                    this.bcb = new a();
                }
                this.bcb.start();
            }
        }
    }

    public void NX() {
        if (Build.VERSION.SDK_INT >= 16 && this.bcb != null) {
            this.bcb.stop();
        }
    }

    public void NY() {
        o oVar;
        if (!this.bcd && this.bcb != null && this.bcb.getFps() >= 0 && (oVar = (o) m.Og().fX(this.mSubType)) != null) {
            oVar.a(this);
            this.bcd = true;
        }
    }

    public int getFps() {
        if (this.bcb != null) {
            return this.bcb.getFps();
        }
        return -1;
    }
}
