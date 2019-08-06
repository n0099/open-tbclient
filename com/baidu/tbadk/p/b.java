package com.baidu.tbadk.p;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private a czI;
    private boolean czJ;
    private boolean czK;

    public void avl() {
        if (!this.czJ && m.avv().avw()) {
            this.czJ = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.czI == null) {
                    this.czI = new a();
                }
                this.czI.start();
            }
        }
    }

    public void avm() {
        if (Build.VERSION.SDK_INT >= 16 && this.czI != null) {
            this.czI.stop();
        }
    }

    public void avn() {
        o oVar;
        if (!this.czK && this.czI != null && this.czI.getFps() >= 0 && (oVar = (o) m.avv().kU(this.mSubType)) != null) {
            oVar.a(this);
            this.czK = true;
        }
    }

    public int getFps() {
        if (this.czI != null) {
            return this.czI.getFps();
        }
        return -1;
    }
}
