package com.baidu.tbadk.p;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private a cyk;
    private boolean cyl;
    private boolean cym;

    public void aua() {
        if (!this.cyl && m.auk().aul()) {
            this.cyl = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.cyk == null) {
                    this.cyk = new a();
                }
                this.cyk.start();
            }
        }
    }

    public void aub() {
        if (Build.VERSION.SDK_INT >= 16 && this.cyk != null) {
            this.cyk.stop();
        }
    }

    public void auc() {
        o oVar;
        if (!this.cym && this.cyk != null && this.cyk.getFps() >= 0 && (oVar = (o) m.auk().kN(this.mSubType)) != null) {
            oVar.a(this);
            this.cym = true;
        }
    }

    public int getFps() {
        if (this.cyk != null) {
            return this.cyk.getFps();
        }
        return -1;
    }
}
