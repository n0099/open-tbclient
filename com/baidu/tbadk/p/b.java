package com.baidu.tbadk.p;

import android.os.Build;
/* loaded from: classes.dex */
public class b extends g {
    private a czB;
    private boolean czC;
    private boolean czD;

    public void avj() {
        if (!this.czC && m.avt().avu()) {
            this.czC = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.czB == null) {
                    this.czB = new a();
                }
                this.czB.start();
            }
        }
    }

    public void avk() {
        if (Build.VERSION.SDK_INT >= 16 && this.czB != null) {
            this.czB.stop();
        }
    }

    public void avl() {
        o oVar;
        if (!this.czD && this.czB != null && this.czB.getFps() >= 0 && (oVar = (o) m.avt().kT(this.mSubType)) != null) {
            oVar.a(this);
            this.czD = true;
        }
    }

    public int getFps() {
        if (this.czB != null) {
            return this.czB.getFps();
        }
        return -1;
    }
}
