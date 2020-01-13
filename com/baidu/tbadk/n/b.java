package com.baidu.tbadk.n;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private a dzh;
    private boolean dzi;
    private boolean dzj;

    public void aOJ() {
        if (!this.dzi && m.aOT().aOU()) {
            this.dzi = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.dzh == null) {
                    this.dzh = new a();
                }
                this.dzh.start();
            }
        }
    }

    public void aOK() {
        if (Build.VERSION.SDK_INT >= 16 && this.dzh != null) {
            this.dzh.stop();
        }
    }

    public void aOL() {
        o oVar;
        if (!this.dzj && this.dzh != null && this.dzh.getFps() >= 0 && (oVar = (o) m.aOT().mw(this.mSubType)) != null) {
            oVar.a(this);
            this.dzj = true;
        }
    }

    public int getFps() {
        if (this.dzh != null) {
            return this.dzh.getFps();
        }
        return -1;
    }
}
